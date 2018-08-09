package lexical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicalTable {

	public static Map<String, TokenCategory> lexemesMap = new HashMap<String, TokenCategory>();
	public static Map<String, TokenCategory> delimiterMap = new HashMap<String, TokenCategory>();
	public static List<Character> symbolList = new ArrayList<Character>();

	static {

		// Operadores

		lexemesMap.put("+", TokenCategory.tOPA);
		lexemesMap.put("-", TokenCategory.tOPA);
		lexemesMap.put("*", TokenCategory.tOPM);
		lexemesMap.put("/", TokenCategory.tOPM);
		lexemesMap.put("^", TokenCategory.tOPE);
		lexemesMap.put("=", TokenCategory.tATR);
		lexemesMap.put("<", TokenCategory.tORC);
		lexemesMap.put(">", TokenCategory.tORC);
		lexemesMap.put("<=", TokenCategory.tORC);
		lexemesMap.put(">=", TokenCategory.tORC);
		lexemesMap.put("==", TokenCategory.tORE);
		lexemesMap.put("!=", TokenCategory.tORE);
		lexemesMap.put("&&", TokenCategory.tAND);
		lexemesMap.put("||", TokenCategory.tOR);
		lexemesMap.put("~", TokenCategory.tNOT);
		lexemesMap.put("++", TokenCategory.tCONCAT);

		// Definidores de escopo

		lexemesMap.put("{", TokenCategory.tOK);
		lexemesMap.put("}", TokenCategory.tCK);
		
		// Definidor de comentário

		lexemesMap.put("#", TokenCategory.tCOMMENT);

		// Delimitadores

		lexemesMap.put("(", TokenCategory.tOP);
		lexemesMap.put(")", TokenCategory.tCP);
		lexemesMap.put("[", TokenCategory.tOB);
		lexemesMap.put("]", TokenCategory.tCB);

		// Separadores

		lexemesMap.put(",", TokenCategory.tSPTR);
		lexemesMap.put(":", TokenCategory.tCO);

		// Terminador de instrução

		lexemesMap.put(";", TokenCategory.tSCO);

		// Palavras-reservadas

		lexemesMap.put("empty", TokenCategory.tEMPTY);
		lexemesMap.put("int", TokenCategory.tINT);
		lexemesMap.put("float", TokenCategory.tFLOAT);
		lexemesMap.put("char", TokenCategory.tCHAR);
		lexemesMap.put("string", TokenCategory.tSTRING);
		lexemesMap.put("bool", TokenCategory.tBOOL);
		lexemesMap.put("module", TokenCategory.tMODULE);
		lexemesMap.put("fun", TokenCategory.tFUN);
		lexemesMap.put("return", TokenCategory.tRETURN);
		lexemesMap.put("main", TokenCategory.tMAIN);
		lexemesMap.put("read", TokenCategory.tREAD);
		lexemesMap.put("show", TokenCategory.tSHOW);
		lexemesMap.put("if", TokenCategory.tIF);
		lexemesMap.put("elif", TokenCategory.tELIF);
		lexemesMap.put("else", TokenCategory.tELSE);
		lexemesMap.put("when", TokenCategory.tWHILE);
		lexemesMap.put("repeater", TokenCategory.tREPEATER);
		lexemesMap.put("true", TokenCategory.tTRUE);
		lexemesMap.put("false", TokenCategory.tFALSE);
		lexemesMap.put("null", TokenCategory.tNULL);

		// Símbolos indicadores de tokens
		
		symbolList.add(' ');
		symbolList.add(',');
		symbolList.add(';');
		symbolList.add('+');
		symbolList.add('-');
		symbolList.add('*');
		symbolList.add('\\');
		symbolList.add('/');
		symbolList.add('#');
		symbolList.add('$');
		symbolList.add('<');
		symbolList.add('>');
		symbolList.add('=');
		symbolList.add('~');
		symbolList.add('(');
		symbolList.add(')');
		symbolList.add('[');
		symbolList.add(']');
		symbolList.add('{');
		symbolList.add('}');
		symbolList.add('\'');
		symbolList.add('"');
	}

}