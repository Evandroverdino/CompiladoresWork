package syntactic.grammar;

public enum NonTerminalName {
	
	MODULE(1), 
	FUNCTIONS(2),
	MAIN(3),
	PARAMS(4),
	PARAMSEXT(5),
	LISTPARAMS(6),
	LISTPARAMSEXT(7),
	TYPE(8),
	RETURNTYPE(9),
	RETURNTYPEEXT(10),
	NAME(11),
	NAMEEXT(12),
	ESCOPE(13),
	COMMANDS(14),
	CMD(15),
	DECLARATION(16),
	CMDEXT(17),
	ATTRIBUTION(18),
	VALUE(19),
	ARRAY(20),
	ARRAYEXT(21),
	ELEMENTS(22),
	ELEMENTSEXT(23),
	CONSTANT(24),
	FUNCCALL(25),
	LISTPARAMSCALL(26),
	LISTPARAMSCALLEXT(27),
	PARAMITEM(28),
	SHOW(29),
	MESSAGE(30),
	MESSAGEEXT(31),
	READ(32),
	IFELSE(33),
	IF(34),
	ELIF(35),
	ELSE(36),
	WHEN(37),
	REPEATER(39),
	RETURN(40),
	RETURNEXT(41),
	EXPRESSION(42);
	
	private int nonTerminalValue;
	
	private NonTerminalName(int value) {
		this.nonTerminalValue = value;
	}
	
	public int getNonTerminalValue() {
		return nonTerminalValue;
	}
	
}
