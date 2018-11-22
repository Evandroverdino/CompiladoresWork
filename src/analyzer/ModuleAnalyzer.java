package analyzer;

import lexical.LexicalAnalyzer;
import syntactic.SyntaticAnalyzer;

public class ModuleAnalyzer {
	
	private static LexicalAnalyzer lexicalAnalyzer;
	private static SyntaticAnalyzer syntaticAnalyzer;
	
	private static String filePath = "files/input/fibonacci.module";

	public static void main(String[] args) {
		lexicalAnalyzer = new LexicalAnalyzer(filePath);
		lexicalAnalyzer.readFile();
		
		syntaticAnalyzer = new SyntaticAnalyzer(lexicalAnalyzer);
		syntaticAnalyzer.analyze();
	}
}
