package lexical;

public class Token {

	private String value;
	private TokenCategory category;
	private int line;
	private int column;

	public Token() {
	}

	public String output() {
		return String.format("[%04d" + ", " + "%04d] " + "(%04d" + ", " + "%s) " + "{%s}", line, column,
                category.getCategoryValue(), category.name(), value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TokenCategory getCategory() {
		return category;
	}

	public void setCategory(TokenCategory category) {
		this.category = category;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}