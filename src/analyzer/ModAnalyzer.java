package analyzer;

import lexical.LexicalAnalyzer;

public class ModAnalyzer {
	
	private static LexicalAnalyzer lexicalAnalyzer;
	private static String filePath = "files/input/fibonacci.module";

	public static void main(String[] args) {
		lexicalAnalyzer = new LexicalAnalyzer(filePath);
		lexicalAnalyzer.readFile();
		lexicalAnalyzer.printTokens();
	}
}
