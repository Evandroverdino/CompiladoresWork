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

	@Override
	public String toString() {
		return String.format("        [%04d, %04d] (%04d, %10s) {%s}", line, column, category.getCategoryValue(),
				category.name(), value);
	}

}