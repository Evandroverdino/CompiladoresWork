package analyzer;

import lexical.LexicalAnalyzer;
import syntactic.SyntaticAnalyzer;

public class ModuleAnalyzer {
	
	private static LexicalAnalyzer lexicalAnalyzer;
	private static SyntaticAnalyzer syntaticAnalyzer;
	
	private static String filePath = "files/input/shellsort.module";

	public static void main(String[] args) {
		lexicalAnalyzer = new LexicalAnalyzer(filePath);
		lexicalAnalyzer.readFile();
		lexicalAnalyzer.printTokens();
		
		syntaticAnalyzer = new SyntaticAnalyzer(lexicalAnalyzer);
		syntaticAnalyzer.analyze();
		/*syntaticAnalyzer.printTokens(lexicalAnalyzer);*/
	}
}
