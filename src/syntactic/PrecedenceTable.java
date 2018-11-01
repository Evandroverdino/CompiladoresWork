package syntactic;

import java.util.ArrayList;
import syntactic.grammar.OperatorsGrammar;

public class PrecedenceTable {
	
	private OperatorsGrammar operatorsGrammar;
	private ArrayList<Integer> lineTable;
	private ArrayList<ArrayList<Integer>> precedenceTableList;
	private static PrecedenceTable precedenceTableSingleton;
	public static final int AC = 100;
	
	//Erro
	public static final int ERROR = -1;
	
	//Empilha e le proximo token
	public static final int EAT = 0;
	
	//Redu��es
	public static final int R1 = 1;
	public static final int R2 = 2;
	public static final int R3 = 3;
	public static final int R4 = 4;
	public static final int R5 = 5;
	public static final int R6 = 6;
	public static final int R7 = 7;
	public static final int R8 = 8;
	public static final int R9 = 9;
	public static final int R10 = 10;
	public static final int R11 = 11;
	public static final int R12 = 12;
	public static final int R13 = 13;
	public static final int R14 = 14;
	public static final int R15 = 15;
	public static final int R16 = 16;
	public static final int R17 = 17;
	public static final int R18 = 18;
	public static final int R19 = 19;
	
	

	private PrecedenceTable() {
		operatorsGrammar = OperatorsGrammar.getInstance();
		lineTable = new ArrayList<Integer>();
		precedenceTableList = new ArrayList<ArrayList<Integer>>();

		loadTable();
	}

	public static PrecedenceTable getInstance() {
		if (precedenceTableSingleton == null) {
			precedenceTableSingleton = new PrecedenceTable();
		}
		return precedenceTableSingleton;
	}

	public ArrayList<ArrayList<Integer>> getPrecedenceTableList() {
		return precedenceTableList;
	}

	public OperatorsGrammar getOperatorsGrammar() {
		return operatorsGrammar;
	}

	private void loadTable() {
		// Relacao 'tOPA' x (todos os terminais)
		lineTable.add(R5);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R5);
		lineTable.add(R5);
		lineTable.add(R5);
		lineTable.add(R5);
		lineTable.add(R5);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R5);
		lineTable.add(R5);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tOPM' x (todos os terminais)
		lineTable.add(R6);
		lineTable.add(R6);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R6);
		lineTable.add(R6);
		lineTable.add(R6);
		lineTable.add(R6);
		lineTable.add(R6);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R6);
		lineTable.add(R6);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tOPE' x (todos os terminais)
		lineTable.add(R9);
		lineTable.add(R9);
		lineTable.add(EAT);
		lineTable.add(R9);
		lineTable.add(R9);
		lineTable.add(EAT);
		lineTable.add(R9);
		lineTable.add(R9);
		lineTable.add(R9);
		lineTable.add(R9);
		lineTable.add(R9);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R9);
		lineTable.add(R9);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tOPU' x (todos os terminais)
		lineTable.add(R7);
		lineTable.add(R7);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R7);
		lineTable.add(R7);
		lineTable.add(R7);
		lineTable.add(R7);
		lineTable.add(R7);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R7);
		lineTable.add(R7);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tNOT' x (todos os terminais)
		lineTable.add(R8);
		lineTable.add(R8);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R8);
		lineTable.add(R8);
		lineTable.add(R8);
		lineTable.add(R8);
		lineTable.add(R8);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R8);
		lineTable.add(R8);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tOP' x (todos os terminais)
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tCP' x (todos os terminais)
		lineTable.add(R10);
		lineTable.add(R10);
		lineTable.add(R10);
		lineTable.add(R10);
		lineTable.add(R10);
		lineTable.add(ERROR);
		lineTable.add(R10);
		lineTable.add(R10);
		lineTable.add(R10);
		lineTable.add(R10);
		lineTable.add(R10);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R10);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tOR' x (todos os terminais)
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R1);
		lineTable.add(R1);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R1);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tAND' x (todos os terminais)
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R2);
		lineTable.add(R2);
		lineTable.add(R2);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R2);
		lineTable.add(R2);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tORC' x (todos os terminais)
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R4);
		lineTable.add(R4);
		lineTable.add(R4);
		lineTable.add(R4);
		lineTable.add(R4);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R4);
		lineTable.add(R4);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tORE' x (todos os terminais)
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R3);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R3);
		lineTable.add(R3);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R3);
		lineTable.add(R3);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tCTEINT' x (todos os terminais)
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(ERROR);
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R11);
		lineTable.add(R11);
		lineTable.add(R11);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tCTEFLOAT' x (todos os terminais)
		lineTable.add(R12);
		lineTable.add(R12);
		lineTable.add(R12);
		lineTable.add(R12);
		lineTable.add(R12);
		lineTable.add(ERROR);
		lineTable.add(R12);
		lineTable.add(R12);
		lineTable.add(R12);
		lineTable.add(R12);
		lineTable.add(R12);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R12);
		lineTable.add(R12);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tTRUE' x (todos os terminais)
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(ERROR);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R13);
		lineTable.add(R13);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();
		
		// Relacao 'tFALSE' x (todos os terminais)
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(ERROR);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(R13);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R13);
		lineTable.add(R13);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tCTECHAR' x (todos os terminais)
		lineTable.add(R14);
		lineTable.add(R14);
		lineTable.add(R14);
		lineTable.add(R14);
		lineTable.add(R14);
		lineTable.add(ERROR);
		lineTable.add(R14);
		lineTable.add(R14);
		lineTable.add(R14);
		lineTable.add(R14);
		lineTable.add(R14);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R14);
		lineTable.add(R14);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tCTESTRING' x (todos os terminais)
		lineTable.add(R15);
		lineTable.add(R15);
		lineTable.add(R15);
		lineTable.add(R15);
		lineTable.add(R15);
		lineTable.add(ERROR);
		lineTable.add(R15);
		lineTable.add(R15);
		lineTable.add(R15);
		lineTable.add(R15);
		lineTable.add(R15);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R15);
		lineTable.add(R15);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tID' x (todos os terminais)
		lineTable.add(R16);
		lineTable.add(R16);
		lineTable.add(R16);
		lineTable.add(R16);
		lineTable.add(R16);
		lineTable.add(EAT);
		lineTable.add(R16);
		lineTable.add(R16);
		lineTable.add(R16);
		lineTable.add(R16);
		lineTable.add(R16);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R16);
		lineTable.add(R16);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tOB' x (todos os terminais)
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tCB' x (todos os terminais)
		lineTable.add(R17); 
		lineTable.add(R17);
		lineTable.add(R17);
		lineTable.add(R17);
		lineTable.add(R17);
		lineTable.add(ERROR);
		lineTable.add(R17);
		lineTable.add(R17);
		lineTable.add(R17);
		lineTable.add(R17);
		lineTable.add(R17);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(R17);
		lineTable.add(R17);
		lineTable.add(R17);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'tSPTR' x (todos os terminais)
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(R19);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();

		// Relacao 'pilha vazia' x (todos os terminais)
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(EAT);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(ERROR);
		lineTable.add(AC);
		precedenceTableList.add(lineTable);
		lineTable = new ArrayList<Integer>();
	}
	
}
