package syntactic;

import java.util.HashMap;
import lexical.TokenCategory;
import syntactic.grammar.NonTerminalName;

public class PredictiveTable {
	private HashMap<NonTerminalName, HashMap<TokenCategory, Integer>> predectiveTableMap;
	private HashMap<TokenCategory, Integer> terminaisMap;

	public PredictiveTable() {
		terminaisMap = new HashMap<TokenCategory, Integer>();
		predectiveTableMap = new HashMap<NonTerminalName, HashMap<TokenCategory, Integer>>();

		loadPredectiveTableMap();
	}

	public Integer getDerivationNumber(NonTerminalName nonTerminal,
			TokenCategory terminal) {
		return predectiveTableMap.get(nonTerminal).get(terminal);
	}

	// Tabela preditiva
	private void loadPredectiveTableMap() {

		terminaisMap.put(TokenCategory.tMAIN, 0);
		terminaisMap.put(TokenCategory.tID, 0);
		predectiveTableMap.put(NonTerminalName.MODULE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 1);
		terminaisMap.put(TokenCategory.tMAIN, 2);
		predectiveTableMap.put(NonTerminalName.FUNCTIONS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tMAIN, 3);
		predectiveTableMap.put(NonTerminalName.MAIN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOP, 4);
		predectiveTableMap.put(NonTerminalName.PARAMS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCB, 5);
		terminaisMap.put(TokenCategory.tINT, 6);
		terminaisMap.put(TokenCategory.tBOOL, 6);
		terminaisMap.put(TokenCategory.tCHAR, 6);
		terminaisMap.put(TokenCategory.tSTRING, 6);
		terminaisMap.put(TokenCategory.tFLOAT, 6);
		predectiveTableMap.put(NonTerminalName.PARAMSEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tINT, 7);
		terminaisMap.put(TokenCategory.tBOOL, 7);
		terminaisMap.put(TokenCategory.tCHAR, 7);
		terminaisMap.put(TokenCategory.tSTRING, 7);
		terminaisMap.put(TokenCategory.tFLOAT, 7);
		predectiveTableMap.put(NonTerminalName.LISTPARAMS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tSPTR, 8);
		terminaisMap.put(TokenCategory.tCP, 9);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tINT, 10);
		terminaisMap.put(TokenCategory.tBOOL, 12);
		terminaisMap.put(TokenCategory.tCHAR, 13);
		terminaisMap.put(TokenCategory.tSTRING, 14);
		terminaisMap.put(TokenCategory.tFLOAT, 15);
		predectiveTableMap.put(NonTerminalName.TYPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tEMPTY, 16);
		terminaisMap.put(TokenCategory.tINT, 17);
		terminaisMap.put(TokenCategory.tBOOL, 17);
		terminaisMap.put(TokenCategory.tCHAR, 17);
		terminaisMap.put(TokenCategory.tSTRING, 17);
		terminaisMap.put(TokenCategory.tFLOAT, 17);
		predectiveTableMap.put(NonTerminalName.RETURNTYPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOK, 19);
		terminaisMap.put(TokenCategory.tOB, 18);
		predectiveTableMap.put(NonTerminalName.RETURNTYPEEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 20);
		predectiveTableMap.put(NonTerminalName.NAME, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCP, 22);
		terminaisMap.put(TokenCategory.tOB, 21);
		terminaisMap.put(TokenCategory.tSCO, 22);
		terminaisMap.put(TokenCategory.tSPTR, 22);
		terminaisMap.put(TokenCategory.tATR, 22);
		terminaisMap.put(TokenCategory.tCONCAT, 22);
		predectiveTableMap.put(NonTerminalName.NAMEEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOK, 23);
		predectiveTableMap.put(NonTerminalName.ESCOPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 24);
		terminaisMap.put(TokenCategory.tINT, 24);
		terminaisMap.put(TokenCategory.tBOOL, 24);
		terminaisMap.put(TokenCategory.tCHAR, 24);
		terminaisMap.put(TokenCategory.tSTRING, 24);
		terminaisMap.put(TokenCategory.tFLOAT, 24);
		terminaisMap.put(TokenCategory.tCK, 25);
		terminaisMap.put(TokenCategory.tREAD, 24);
		terminaisMap.put(TokenCategory.tSHOW, 24);
		terminaisMap.put(TokenCategory.tIF, 24);
		terminaisMap.put(TokenCategory.tREPEATER, 24);
		terminaisMap.put(TokenCategory.tWHEN, 24);
		terminaisMap.put(TokenCategory.tRETURN, 24);
		predectiveTableMap.put(NonTerminalName.COMMANDS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 27);
		terminaisMap.put(TokenCategory.tINT, 26);
		terminaisMap.put(TokenCategory.tBOOL, 26);
		terminaisMap.put(TokenCategory.tCHAR, 26);
		terminaisMap.put(TokenCategory.tSTRING, 26);
		terminaisMap.put(TokenCategory.tFLOAT, 26);
		terminaisMap.put(TokenCategory.tREAD, 29);
		terminaisMap.put(TokenCategory.tSHOW, 28);
		terminaisMap.put(TokenCategory.tIF, 30);
		terminaisMap.put(TokenCategory.tREPEATER, 33);
		terminaisMap.put(TokenCategory.tWHEN, 31);
		terminaisMap.put(TokenCategory.tRETURN, 29);
		predectiveTableMap.put(NonTerminalName.CMD, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tINT, 35);
		terminaisMap.put(TokenCategory.tBOOL, 35);
		terminaisMap.put(TokenCategory.tCHAR, 35);
		terminaisMap.put(TokenCategory.tSTRING, 35);
		terminaisMap.put(TokenCategory.tFLOAT, 35);
		predectiveTableMap.put(NonTerminalName.DECLARATION, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOP, 37);
		terminaisMap.put(TokenCategory.tOB, 36);
		terminaisMap.put(TokenCategory.tATR, 36);
		predectiveTableMap.put(NonTerminalName.CMDEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOB, 38);
		terminaisMap.put(TokenCategory.tATR, 38);
		predectiveTableMap.put(NonTerminalName.ATTRIBUTION, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOB, 39);
		predectiveTableMap.put(NonTerminalName.VALUE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOB, 40);
		predectiveTableMap.put(NonTerminalName.ARRAY, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCB, 42);
		terminaisMap.put(TokenCategory.tCTEINT, 41);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 41);
		terminaisMap.put(TokenCategory.tCTEBOOL, 41);
		terminaisMap.put(TokenCategory.tCTECHAR, 41);
		terminaisMap.put(TokenCategory.tCTESTRING, 41);
		predectiveTableMap.put(NonTerminalName.ARRAYEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCTEINT, 43);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 43);
		terminaisMap.put(TokenCategory.tCTEBOOL, 43);
		terminaisMap.put(TokenCategory.tCTECHAR, 43);
		terminaisMap.put(TokenCategory.tCTESTRING, 43);
		predectiveTableMap.put(NonTerminalName.ELEMENTS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCB, 45);
		terminaisMap.put(TokenCategory.tSPTR, 44);
		predectiveTableMap.put(NonTerminalName.ELEMENTSEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCTEINT, 46);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 47);
		terminaisMap.put(TokenCategory.tCTEBOOL, 48);
		terminaisMap.put(TokenCategory.tCTECHAR, 49);
		terminaisMap.put(TokenCategory.tCTESTRING, 50);
		predectiveTableMap.put(NonTerminalName.CONSTANT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOP, 51);
		predectiveTableMap.put(NonTerminalName.FUNCCALL, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 52);
		terminaisMap.put(TokenCategory.tCTEINT, 52);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 52);
		terminaisMap.put(TokenCategory.tCTEBOOL, 52);
		terminaisMap.put(TokenCategory.tCTECHAR, 52);
		terminaisMap.put(TokenCategory.tCTESTRING, 52);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSCALL, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCP, 54);
		terminaisMap.put(TokenCategory.tSPTR, 53);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSCALLEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 56);
		terminaisMap.put(TokenCategory.tCTEINT, 55);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 55);
		terminaisMap.put(TokenCategory.tCTEBOOL, 55);
		terminaisMap.put(TokenCategory.tCTECHAR, 55);
		terminaisMap.put(TokenCategory.tCTESTRING, 55);
		predectiveTableMap.put(NonTerminalName.PARAMITEM, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tSHOW, 57);
		predectiveTableMap.put(NonTerminalName.SHOW, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 59);
		terminaisMap.put(TokenCategory.tCTESTRING, 58);
		predectiveTableMap.put(NonTerminalName.MESSAGE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCP, 61);
		terminaisMap.put(TokenCategory.tCONCAT, 60);
		predectiveTableMap.put(NonTerminalName.MESSAGEEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tREAD, 62);
		predectiveTableMap.put(NonTerminalName.READ, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tIF, 63);
		predectiveTableMap.put(NonTerminalName.IFELSE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tIF, 64);
		predectiveTableMap.put(NonTerminalName.IF, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tELIF, 65);
		terminaisMap.put(TokenCategory.tELSE, 66);
		terminaisMap.put(TokenCategory.tSCO, 66);
		predectiveTableMap.put(NonTerminalName.ELIF, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tELSE, 67);
		terminaisMap.put(TokenCategory.tSCO, 68);
		predectiveTableMap.put(NonTerminalName.ELSE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tWHEN, 69);
		predectiveTableMap.put(NonTerminalName.WHEN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tREPEATER, 71);
		predectiveTableMap.put(NonTerminalName.REPEATER, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tRETURN, 72);
		predectiveTableMap.put(NonTerminalName.RETURN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 74);
		terminaisMap.put(TokenCategory.tCTEINT, 73);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 73);
		terminaisMap.put(TokenCategory.tCTEBOOL, 73);
		terminaisMap.put(TokenCategory.tCTECHAR, 73);
		terminaisMap.put(TokenCategory.tCTESTRING, 73);
		predectiveTableMap.put(NonTerminalName.RETURNEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

	}

}
