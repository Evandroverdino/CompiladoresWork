package syntactic.grammar;

import java.util.ArrayList;
import java.util.List;

import lexical.TokenCategory;

public class OperatorsGrammar {
	private List<Derivation> operatorGrammarArray;
	private Derivation operatorDerivation;
	private List<TokenCategory> operatorsGrammarSymbols;
	private static OperatorsGrammar operatorsGrammarSingleton;

	private OperatorsGrammar() {
		operatorGrammarArray = new ArrayList<Derivation>();
		operatorsGrammarSymbols = new ArrayList<TokenCategory>();

		loadOperatorGrammar();
		loadOperatorsGrammarSymbols();
	}

	public List<TokenCategory> getOperatorsGrammarSymbols() {
		return operatorsGrammarSymbols;
	}

	private void loadOperatorsGrammarSymbols() {
		operatorsGrammarSymbols.add(TokenCategory.tOPA);// 0
		operatorsGrammarSymbols.add(TokenCategory.tOPM);// 1
		operatorsGrammarSymbols.add(TokenCategory.tOPE);// 2
		operatorsGrammarSymbols.add(TokenCategory.tOPU);// 3
		operatorsGrammarSymbols.add(TokenCategory.tNOT);// 4
		operatorsGrammarSymbols.add(TokenCategory.tOP);// 5
		operatorsGrammarSymbols.add(TokenCategory.tCP);// 6
		operatorsGrammarSymbols.add(TokenCategory.tOR);// 7
		operatorsGrammarSymbols.add(TokenCategory.tAND);// 8
		operatorsGrammarSymbols.add(TokenCategory.tORC);// 9
		operatorsGrammarSymbols.add(TokenCategory.tORE);// 10
		operatorsGrammarSymbols.add(TokenCategory.tCTEINT);// 11
		operatorsGrammarSymbols.add(TokenCategory.tCTEFLOAT);// 12
		operatorsGrammarSymbols.add(TokenCategory.tCTEBOOL);// 13
		operatorsGrammarSymbols.add(TokenCategory.tCTECHAR);// 14
		operatorsGrammarSymbols.add(TokenCategory.tCTESTRING);// 15
		operatorsGrammarSymbols.add(TokenCategory.tID);// 16
		operatorsGrammarSymbols.add(TokenCategory.tOB);// 17
		operatorsGrammarSymbols.add(TokenCategory.tCB);// 18
		operatorsGrammarSymbols.add(TokenCategory.tSPTR);// 19
	}

	public static OperatorsGrammar getInstance() {
		if (operatorsGrammarSingleton == null) {
			operatorsGrammarSingleton = new OperatorsGrammar();
		}
		return operatorsGrammarSingleton;
	}

	public Derivation getOperatorDerivation(int index) {
		return operatorGrammarArray.get(index);
	}

	private void loadOperatorGrammar() {
		
		// (0)EXPRESSION = EXPRESSION tOR EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tOR));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (1)EXPRESSION = EXPRESSION tAND EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tAND));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (2)EXPRESSION = EXPRESSION tORE EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tORE));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (3)EXPRESSION = EXPRESSION tORC EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tORC));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (4)EXPRESSION = EXPRESSION tOPA EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tOPA));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (5)EXPRESSION = EXPRESSION tOPM EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tOPM));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (6)EXPRESSION = EXPRESSION tOPU EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tOPU));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (7)EXPRESSION = EXPRESSION tNOT EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tNOT));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (8)EXPRESSION = EXPRESSION tOPE EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tOPE));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);

		// (9)EXPRESSION = tOP EXPRESSION tCP
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tOP));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tCP));
		operatorGrammarArray.add(operatorDerivation);

		// (10)EXPRESSION = tCTEINT
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tCTEINT));
		operatorGrammarArray.add(operatorDerivation);

		// (11)EXPRESSION = tCTEFLOAT
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tCTEFLOAT));
		operatorGrammarArray.add(operatorDerivation);

		// (12)EXPRESSION = tCTEBOOL
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tCTEBOOL));
		operatorGrammarArray.add(operatorDerivation);

		// (13)EXPRESSION = tCTECHAR
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tCTECHAR));
		operatorGrammarArray.add(operatorDerivation);

		// (14)EXPRESSION = tCTESTRING
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tCTESTRING));
		operatorGrammarArray.add(operatorDerivation);

		// (15)EXPRESSION = tID
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tID));
		operatorGrammarArray.add(operatorDerivation);

		// (16)EXPRESSION = tID tOB EXPRESSION tCB
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tID));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tOB));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tCB));
		operatorGrammarArray.add(operatorDerivation);

		// (17)EXPRESSION = tID tOP EXPRESSION tCP
		operatorDerivation = new Derivation();
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tID));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tOP));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tCP));
		operatorGrammarArray.add(operatorDerivation);

		// (18)EXPRESSION = EXPRESSION tSPTR EXPRESSION
		operatorDerivation = new Derivation();
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorDerivation.addSymbol(new Terminal(TokenCategory.tSPTR));
		operatorDerivation
				.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		operatorGrammarArray.add(operatorDerivation);
	}

}
