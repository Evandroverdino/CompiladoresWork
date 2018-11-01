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

	public Integer getDerivationNumber(NonTerminalName nonTerminal, TokenCategory terminal) {
		return predectiveTableMap.get(nonTerminal).get(terminal);
	}

	// Tabela preditiva
	private void loadPredectiveTableMap() {
		terminaisMap.put(TokenCategory.tMAIN, 0);
		terminaisMap.put(TokenCategory.tID, 0);
		predectiveTableMap.put(NonTerminalName.MODULE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 2);
		terminaisMap.put(TokenCategory.tMAIN, 3);
		predectiveTableMap.put(NonTerminalName.FUNCTIONS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tMAIN, 4);
		predectiveTableMap.put(NonTerminalName.MAIN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOP, 5);
		predectiveTableMap.put(NonTerminalName.PARAMS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCP, 6);
		terminaisMap.put(TokenCategory.tINT, 7);
		terminaisMap.put(TokenCategory.tBOOL, 7);
		terminaisMap.put(TokenCategory.tCHAR, 7);
		terminaisMap.put(TokenCategory.tSTRING, 7);
		terminaisMap.put(TokenCategory.tFLOAT, 7);
		predectiveTableMap.put(NonTerminalName.PARAMSEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tINT, 8);
		terminaisMap.put(TokenCategory.tBOOL, 8);
		terminaisMap.put(TokenCategory.tCHAR, 8);
		terminaisMap.put(TokenCategory.tSTRING, 8);
		terminaisMap.put(TokenCategory.tFLOAT, 8);
		predectiveTableMap.put(NonTerminalName.LISTPARAMS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tSPTR, 9);
		terminaisMap.put(TokenCategory.tCP, 10);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tINT, 11);
		terminaisMap.put(TokenCategory.tBOOL, 15);
		terminaisMap.put(TokenCategory.tCHAR, 13);
		terminaisMap.put(TokenCategory.tSTRING, 14);
		terminaisMap.put(TokenCategory.tFLOAT, 12);
		predectiveTableMap.put(NonTerminalName.TYPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tEMPTY, 17);
		terminaisMap.put(TokenCategory.tINT, 18);
		terminaisMap.put(TokenCategory.tBOOL, 18);
		terminaisMap.put(TokenCategory.tCHAR, 18);
		terminaisMap.put(TokenCategory.tSTRING, 18);
		terminaisMap.put(TokenCategory.tFLOAT, 18);
		predectiveTableMap.put(NonTerminalName.RETURNTYPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOK, 20);
		terminaisMap.put(TokenCategory.tOB, 19);
		predectiveTableMap.put(NonTerminalName.RETURNTYPEEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 21);
		predectiveTableMap.put(NonTerminalName.NAME, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCP, 23);
		terminaisMap.put(TokenCategory.tOB, 22);
		//terminaisMap.put(TokenCategory.tSCO, 22);
		terminaisMap.put(TokenCategory.tSPTR, 23);
		//terminaisMap.put(TokenCategory.tATR, 22);
		//terminaisMap.put(TokenCategory.tCONCAT, 22);
		predectiveTableMap.put(NonTerminalName.NAMEEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOK, 24);
		predectiveTableMap.put(NonTerminalName.ESCOPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 25);
		terminaisMap.put(TokenCategory.tINT, 25);
		terminaisMap.put(TokenCategory.tBOOL, 25);
		terminaisMap.put(TokenCategory.tCHAR, 25);
		terminaisMap.put(TokenCategory.tSTRING, 25);
		terminaisMap.put(TokenCategory.tFLOAT, 25);
		terminaisMap.put(TokenCategory.tCK, 26);
		terminaisMap.put(TokenCategory.tREAD, 25);
		terminaisMap.put(TokenCategory.tSHOW, 25);
		terminaisMap.put(TokenCategory.tIF, 25);
		terminaisMap.put(TokenCategory.tREPEATER, 25);
		terminaisMap.put(TokenCategory.tWHEN, 25);
		terminaisMap.put(TokenCategory.tRETURN, 25);
		predectiveTableMap.put(NonTerminalName.COMMANDS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 28);
		terminaisMap.put(TokenCategory.tINT, 27);
		terminaisMap.put(TokenCategory.tBOOL, 27);
		terminaisMap.put(TokenCategory.tCHAR, 27);
		terminaisMap.put(TokenCategory.tSTRING, 27);
		terminaisMap.put(TokenCategory.tFLOAT, 27);
		terminaisMap.put(TokenCategory.tREAD, 30);
		terminaisMap.put(TokenCategory.tSHOW, 29);
		terminaisMap.put(TokenCategory.tIF, 31);
		terminaisMap.put(TokenCategory.tREPEATER, 34);
		terminaisMap.put(TokenCategory.tWHEN, 32);
		terminaisMap.put(TokenCategory.tRETURN, 35);
		predectiveTableMap.put(NonTerminalName.CMD, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tINT, 36);
		terminaisMap.put(TokenCategory.tBOOL, 36);
		terminaisMap.put(TokenCategory.tCHAR, 36);
		terminaisMap.put(TokenCategory.tSTRING, 36);
		terminaisMap.put(TokenCategory.tFLOAT, 36);
		predectiveTableMap.put(NonTerminalName.DECLARATION, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 37);
		terminaisMap.put(TokenCategory.tOP, 38);
		//terminaisMap.put(TokenCategory.tOB, 36);
		//terminaisMap.put(TokenCategory.tATR, 36);
		predectiveTableMap.put(NonTerminalName.CMDEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 39);
		//terminaisMap.put(TokenCategory.tOB, 38);
		//terminaisMap.put(TokenCategory.tATR, 38);
		predectiveTableMap.put(NonTerminalName.ATTRIBUTION, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOB, 40);
		predectiveTableMap.put(NonTerminalName.VALUE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOB, 41);
		predectiveTableMap.put(NonTerminalName.ARRAY, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCB, 43);
		terminaisMap.put(TokenCategory.tCTEINT, 42);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 42);
		terminaisMap.put(TokenCategory.tFALSE, 42);
		terminaisMap.put(TokenCategory.tTRUE, 42);
		terminaisMap.put(TokenCategory.tCTECHAR, 42);
		terminaisMap.put(TokenCategory.tCTESTRING, 42);
		predectiveTableMap.put(NonTerminalName.ARRAYEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCTEINT, 44);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 44);
		terminaisMap.put(TokenCategory.tFALSE, 44);
		terminaisMap.put(TokenCategory.tTRUE, 44);
		terminaisMap.put(TokenCategory.tCTECHAR, 44);
		terminaisMap.put(TokenCategory.tCTESTRING, 44);
		predectiveTableMap.put(NonTerminalName.ELEMENTS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCB, 46);
		terminaisMap.put(TokenCategory.tSPTR, 45);
		predectiveTableMap.put(NonTerminalName.ELEMENTSEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCTEINT, 47);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 48);
		terminaisMap.put(TokenCategory.tTRUE, 51);
		terminaisMap.put(TokenCategory.tFALSE, 52);
		terminaisMap.put(TokenCategory.tCTECHAR, 49);
		terminaisMap.put(TokenCategory.tCTESTRING, 50);
		predectiveTableMap.put(NonTerminalName.CONSTANT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tOP, 53);
		predectiveTableMap.put(NonTerminalName.FUNCCALL, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 53);
		terminaisMap.put(TokenCategory.tCTEINT, 54);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 54);
		terminaisMap.put(TokenCategory.tTRUE, 54);
		terminaisMap.put(TokenCategory.tFALSE, 54);
		terminaisMap.put(TokenCategory.tCTECHAR, 54);
		terminaisMap.put(TokenCategory.tCTESTRING, 54);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSCALL, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCP, 54);
		terminaisMap.put(TokenCategory.tSPTR, 53);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSCALLEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 58);
		terminaisMap.put(TokenCategory.tCTEINT, 57);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 57);
		terminaisMap.put(TokenCategory.tTRUE, 57);
		terminaisMap.put(TokenCategory.tFALSE, 57);
		terminaisMap.put(TokenCategory.tCTECHAR, 57);
		terminaisMap.put(TokenCategory.tCTESTRING, 57);
		predectiveTableMap.put(NonTerminalName.PARAMITEM, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tSHOW, 59);
		predectiveTableMap.put(NonTerminalName.SHOW, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 61);
		terminaisMap.put(TokenCategory.tCTESTRING, 60);
		predectiveTableMap.put(NonTerminalName.MESSAGE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tCP, 63);
		terminaisMap.put(TokenCategory.tCONCAT, 62);
		predectiveTableMap.put(NonTerminalName.MESSAGEEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tREAD, 64);
		predectiveTableMap.put(NonTerminalName.READ, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tIF, 65);
		predectiveTableMap.put(NonTerminalName.IFELSE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tIF, 66);
		predectiveTableMap.put(NonTerminalName.IF, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tELIF, 67);
		terminaisMap.put(TokenCategory.tELSE, 68);
		terminaisMap.put(TokenCategory.tSCO, 68);
		predectiveTableMap.put(NonTerminalName.ELIF, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tELSE, 69);
		terminaisMap.put(TokenCategory.tSCO, 70);
		predectiveTableMap.put(NonTerminalName.ELSE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tWHEN, 71);
		predectiveTableMap.put(NonTerminalName.WHEN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tREPEATER, 72);
		predectiveTableMap.put(NonTerminalName.REPEATER, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tRETURN, 73);
		predectiveTableMap.put(NonTerminalName.RETURN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.tID, 75);
		terminaisMap.put(TokenCategory.tCTEINT, 74);
		terminaisMap.put(TokenCategory.tCTEFLOAT, 74);
		terminaisMap.put(TokenCategory.tTRUE, 74);
		terminaisMap.put(TokenCategory.tFALSE, 74);
		terminaisMap.put(TokenCategory.tCTECHAR, 74);
		terminaisMap.put(TokenCategory.tCTESTRING, 74);
		predectiveTableMap.put(NonTerminalName.RETURNEXT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
	}

}
