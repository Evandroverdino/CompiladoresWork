package lexical;

public class Token {

	private String value;
	private TokenCategory category;
	private int line;
	private int column;

	public Token(String tokenValue, int tokenBeginLine, int tokenBeginColumn, TokenCategory tokenCategory) {
		this.value = tokenValue;
		this.category = tokenCategory;
		this.line = tokenBeginLine;
		this.column = tokenBeginColumn;
	}

	public String output() {
		return String.format("\t\t[%04d" + ", " + "%04d] " + "(%04d" + ", " + "%s) " + "{%s}", line, column,
				category.getCategoryValue(), category.name(), value);
	}

}