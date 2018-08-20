package lexical;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {

	private List<String> linesList;
	private String line;
	private String filePath;
	private int currentLine, currentColumn = 0;
	private int tokenBeginColumn, tokenBeginLine = 0;
	private String tokenValue;
	private char currentChar;

	private final char LINE_BREAK = '\n';

	public LexicalAnalyzer(String filePath) {
		linesList = new ArrayList<String>();
		this.filePath = filePath;
	}

	public void readFile() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();

			while (line != null) {
				linesList.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public boolean hasMoreTokens() {
		if (!linesList.isEmpty()) {
			if (currentLine < linesList.size()) {
				line = linesList.get(currentLine);

				if (line.substring(currentColumn).matches("\\s*")) {
					currentLine++;
					currentColumn = 0;

					while (currentLine < linesList.size()) {
						line = linesList.get(currentLine);

						if (line.matches("\\s*")) {
							currentLine++;
						} else {
							return true;
						}
					}
				} else if (currentColumn < line.length()) {
					return true;
				} else {
					currentLine++;
					currentColumn = 0;

					while (currentLine < linesList.size()) {
						line = linesList.get(currentLine);

						if (line.matches("\\s*")) {
							currentLine++;
						} else {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public Token nextToken() {
		Token token;
		tokenValue = "";

		tokenBeginColumn = currentColumn;
		tokenBeginLine = currentLine;
		currentChar = line.charAt(currentColumn);

		while (currentChar == ' ' || currentChar == '\t') {
			currentChar = nextChar();
			tokenBeginColumn++;
		}

		if (Character.toString(currentChar).matches("\\d")) {
			appendTokenValue();
			currentChar = nextChar();
			while (Character.toString(currentChar).matches("\\d")) {
				appendTokenValue();
				currentChar = nextChar();
				if (currentChar == '.') {
					while (Character.toString(currentChar).matches("\\d")) {
						appendTokenValue();
						currentChar = nextChar();
					}
				}
				if (currentChar != ' ') {
					buildIdentifier();
				}
			}
		} else {
			buildIdentifier();
		}

		if (tokenValue == "") {
			switch (currentChar) {
			case '"':
				appendTokenValue();
				currentChar = nextChar();

				if (currentChar == '"') {
					appendTokenValue();
					currentColumn++;
					break;
				}
				while (currentChar != LINE_BREAK) {
					appendTokenValue();
					currentChar = nextChar();

					if (currentChar == '"') {
						appendTokenValue();
						currentColumn++;
						break;
					}
				}
				break;
			case '\'':
				appendTokenValue();
				currentChar = nextChar();

				if (currentChar != LINE_BREAK) {
					appendTokenValue();
				}

				currentChar = nextChar();
				if (currentChar == '\'') {
					appendTokenValue();
					currentColumn++;
				}
				break;
			case '<':
			case '>':
			case '!':
			case '=':
				appendTokenValue();
				currentChar = nextChar();
				if (currentChar == '=') {
					appendTokenValue();
					currentColumn++;
				}
				break;
			case '+':
				appendTokenValue();
				currentChar = nextChar();

				if (currentChar == '+') {
					appendTokenValue();
					currentChar = nextChar();
				}
				break;
			default:
				appendTokenValue();
				currentColumn++;
				break;
			}
		}
		tokenValue = tokenValue.trim();

		token = new Token(tokenValue, tokenBeginLine, tokenBeginColumn, analyzeCategory(tokenValue));
		return token;
	}

	private void appendTokenValue() {
		tokenValue += currentChar;
	}

	private void buildIdentifier() {
		while (!LexicalTable.symbolList.contains(currentChar)) {
			tokenValue += currentChar;
			currentChar = nextChar();
			if (currentChar == LINE_BREAK) {
				break;
			}
		}
	}

	private TokenCategory analyzeCategory(String tokenValue) {
		if (isOpeUnary(tokenValue)) {
			return TokenCategory.tOPU;
		} else if (LexicalTable.lexemesMap.containsKey(tokenValue)) {
			return LexicalTable.lexemesMap.get(tokenValue);
		} else if (isCteString(tokenValue)) {
			return TokenCategory.tCTESTRING;
		} else if (isCteChar(tokenValue)) {
			return TokenCategory.tCHAR;
		} else if (isCteInt(tokenValue)) {
			return TokenCategory.tCTEINT;
		} else if (isCteFloat(tokenValue)) {
			return TokenCategory.tCTEFLOAT;
		} else if (isIdentifier(tokenValue)) {
			return TokenCategory.tID;
		}
		return TokenCategory.tNULL;
	}

	private Character nextChar() {
		currentColumn++;
		if (currentColumn < line.length()) {
			return line.charAt(currentColumn);
		} else {
			return LINE_BREAK;
		}
	}

	private Character previousNotBlankChar() {
		int previousColumn = tokenBeginColumn - 1;
		char previousChar;

		while (previousColumn >= 0) {
			previousChar = line.charAt(previousColumn);
			if (previousChar != ' ' && previousChar != '\t') {
				return previousChar;
			}
			previousColumn--;
		}
		return null;
	}

	public void printTokens() {
		Token token;
		for (int i = 0; i < linesList.size(); i++) {
			System.out.println(linesList.get(i));
			while (hasMoreTokens()) {
				if (currentLine != i) {
					break;
				}
				token = nextToken();
				System.out.println(token.toString());
			}
		}
	}

	private boolean isIdentifier(String tokenValue) {
		if (tokenValue.matches("[a-zA-Z][a-zA-Z0-9]*")) {
			if (tokenValue.length() < 32) {
				return true;
			} else {
				printError("Identificador muito longo.", tokenValue);
			}
		} else {
			printError("Identificador n�o iniciado com letra.", tokenValue);
		}
		return false;
	}

	private boolean isCteInt(String tokenValue) {
		if (tokenValue.matches("(\\d)+")) {
			return true;
		}
		return false;
	}

	private boolean isCteFloat(String tokenValue) {
		if (tokenValue.matches("(\\d)+\\.(\\d)+")) {
			return true;
		} else if (tokenValue.matches("(\\d)+\\.")) {
			printError("Constante float em formato errado.", tokenValue);
		}
		return false;
	}

	private boolean isCteChar(String tokenValue) {
		if (tokenValue.matches("'(.?)'")) {
			return true;
		} else if (tokenValue.startsWith("'")) {
			printError("Caracter n�o fechado corretamente com '.", tokenValue);
		}
		return false;
	}

	private boolean isCteString(String tokenValue) {
		if (tokenValue.startsWith("\"") && tokenValue.endsWith("\"")) {
			return true;
		} else if (tokenValue.startsWith("\"")) {
			printError("Cadeia de caracteres n�o fechada corretamente com '\"'.", tokenValue);
		}
		return false;
	}

	private boolean isOpeUnary(String tokenValue) {
		if (tokenValue.equals("-")) {
			Character previousChar = previousNotBlankChar();
			if ((previousChar != null) && Character.toString(previousChar).matches("[a-zA-Z][a-zA-Z0-9]*")) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	private void printError(String string, String token) {
		System.err.println("Erro na <linha, coluna> " + "= <" + currentLine + "," + currentColumn + ">. " + "'" + token
				+ "'" + " " + string);
		System.exit(1);
	}
}