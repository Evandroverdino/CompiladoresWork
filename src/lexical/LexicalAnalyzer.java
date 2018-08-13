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
				line = line.replace('\t', ' ');

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
			incrementTokenValue();
			currentChar = nextChar();
			while (Character.toString(currentChar).matches("\\d")) {
				incrementTokenValue();
				currentChar = nextChar();
				if (currentChar == '.') {
					while (Character.toString(currentChar).matches("\\d")) {
						incrementTokenValue();
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
				incrementTokenValue();
				currentChar = nextChar();

				if (currentChar == '"') {
					incrementTokenValue();
					currentColumn++;
					break;
				}
				while (currentChar != LINE_BREAK) {
					incrementTokenValue();
					currentChar = nextChar();

					if (currentChar == '"') {
						incrementTokenValue();
						currentColumn++;
						break;
					}
				}
				break;
			case '\'':
				incrementTokenValue();
				currentChar = nextChar();

				if (currentChar != LINE_BREAK) {
					incrementTokenValue();
				}

				currentChar = nextChar();
				if (currentChar == '\'') {
					incrementTokenValue();
					currentColumn++;
				}
				break;
			case '<':
			case '>':
			case '!':
			case '=':
				incrementTokenValue();
				currentChar = nextChar();
				if (currentChar == '=') {
					incrementTokenValue();
					currentColumn++;
				}
				break;
			case '+':
				incrementTokenValue();
				currentChar = nextChar();

				if (currentChar == '+') {
					incrementTokenValue();
					currentChar = nextChar();
				}
				break;
			default:
				incrementTokenValue();
				currentColumn++;
				break;
			}
		}
		tokenValue = tokenValue.trim();

		token = new Token();
		token.setValue(tokenValue);
		token.setLine(tokenBeginLine);
		token.setColumn(tokenBeginColumn);
		token.setCategory(analyzeCategory(tokenValue));
		return token;
	}

	private void incrementTokenValue() {
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

	/*
	 * private void showCurrentLine(boolean showLine) { System.out.println(showLine
	 * ? line : ""); }
	 */

	public void printTokens() {
		Token token;
		while (hasMoreTokens()) {
			token = nextToken();
			System.out.println(token.output());
		}
	}

	private boolean isIdentifier(String tokenValue) {
		if (tokenValue.matches("[a-zA-Z][a-zA-Z0-9]*")) {
			if (tokenValue.length() < 32) {
				return true;
			} else {
				printError("Identificador muito longo.", tokenValue);
			}
		} else if (tokenValue.matches("[^_a-zA-Z\"'].*")) {
			/*
			 * Caso em que o identificador n�o come�a com o caractere esperado. Tamb�m n�o
			 * considera tokenValue que come�a com ", ' ou n�mero pois caso algum tokenValue
			 * nessa condi��o chegue at� aqui, � uma string ou um char que n�o foi
			 * propriamente fechado, ou uma constante decimal em formato errado. Enquanto
			 * nao for encontrado um s�mbolo especial, os caracteres serao concatenados em
			 * uma string que dever� ser um token identificador ou palavra chave.
			 */
			printError("Identificador n�o iniciado com letra.", tokenValue);
		} else if (tokenValue.matches("[_a-zA-Z].*")) {
			/*
			 * Caso em que o identificador come�a com o caracter esperado, mas cont�m algum
			 * caracter inv�lido,
			 */
			printError("Identificador cont�m caracter inv�lido.", tokenValue);
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