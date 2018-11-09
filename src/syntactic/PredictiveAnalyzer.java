package syntactic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lexical.LexicalAnalyzer;
import lexical.Token;
import lexical.TokenCategory;
import syntactic.grammar.Derivation;
import syntactic.grammar.Grammar;
import syntactic.grammar.NonTerminal;
import syntactic.grammar.NonTerminalName;
import syntactic.grammar.OperatorsGrammar;
import syntactic.grammar.Symbol;
import syntactic.grammar.Terminal;

public class PredictiveAnalyzer {

	private Grammar grammar;
	private PredictiveTable predictiveTable;
	private LexicalAnalyzer lexicalAnalyzer;
	private PrecedenceAnalyzer precedenceAnalyzer;

	private Stack<Symbol> stack;
	private Derivation derivation;

	private List<String> linesPrinted;
	
	private Token previousToken;
	private Token token;

	public PredictiveAnalyzer(Grammar grammar, PredictiveTable predictiveTable, 
			LexicalAnalyzer lexicalAnalyzer) {

		this.grammar = grammar;
		this.predictiveTable = predictiveTable;
		this.lexicalAnalyzer = lexicalAnalyzer;
		precedenceAnalyzer = new PrecedenceAnalyzer(lexicalAnalyzer);

		stack = new Stack<Symbol>();
		derivation = new Derivation();

		linesPrinted = new ArrayList<String>();
	}

	public void predictiveAnalyze() {
		Symbol topSymbol;
		token = new Token();
		Terminal terminal;
		NonTerminal topNonTerminal;
		Integer derivationNumber;
		Stack<Integer> prodCount = new Stack<Integer>();
		int leftCount = 0;
		int rightCount = 1;
		int rightCountAux = 0;

		if (lexicalAnalyzer.hasMoreTokens()) {
			previousToken = null;
			token = lexicalAnalyzer.nextToken();

			terminal = new Terminal(token);
			stack.push(new NonTerminal(NonTerminalName.MODULE));
			prodCount.push(1);

			while (!stack.isEmpty()) {
				checkLinesToPrint();
				topSymbol = stack.peek();

				if (topSymbol.isTerminal()) {
					if (topSymbol.getValue() == terminal.getValue()) {
						stack.pop();
						if (lexicalAnalyzer.hasMoreTokens()) {
							previousToken = token;
							token = lexicalAnalyzer.nextToken();
							terminal = new Terminal(token);
							checkLinesToPrint();
						}
					} else {
						showSyntaticError(token);
					}

				} else {
					topNonTerminal = (NonTerminal) topSymbol;

					if (topNonTerminal.getName() == NonTerminalName.EXPRESSION) {
						if (!OperatorsGrammar.getInstance()
								.getOperatorsGrammarSymbols()
								.contains(terminal.getCategory())) {
							showSyntaticError(token);

						} else {
							if (precedenceAnalyzer.precedenceAnalysis(token)) {
								stack.pop();
								topSymbol = stack.peek();

								terminal = new Terminal(
										precedenceAnalyzer.getEndOfSentence());
							}
						}
					} else {
						derivationNumber = null;

						if (topNonTerminal.getName() == NonTerminalName.VALUE
								&& terminal.getCategory() != TokenCategory.tOB) {
							derivationNumber = Grammar.EXPRESSION;

						} else {
							derivationNumber = predictiveTable
									.getDerivationNumber(topNonTerminal.getName(), terminal.getCategory());
						}

						if (derivationNumber != null) {
							leftCount = prodCount.pop();
							rightCountAux = rightCount;

							derivation = grammar.getGrammarMap().get(derivationNumber);

							if (derivation != null) {
								System.out.print("          " + topNonTerminal.getName() + "(" + leftCount + ")" + " = ");
								stack.pop();

								Symbol symb;
								Terminal term;
								NonTerminal nonTerm;

								for (int i = derivation.getSymbolsList().size() - 1; i >= 0; i--) {
									symb = derivation.getSymbolsList().get(i);
									if (symb.isTerminal()) {
										term = (Terminal) symb;
									} else {
										nonTerm = (NonTerminal) symb;
									}
									stack.push(symb);
								}

								for (int i = 0; i < derivation.getSymbolsList().size(); i++) {
									symb = derivation.getSymbolsList().get(i);
									if (symb.isTerminal()) {
										term = (Terminal) symb;
										System.out.print("'" + term.getCategory().toString().toLowerCase() + "'" + " ");
									} else {
										nonTerm = (NonTerminal) symb;
										if (!nonTerm.getName().equals(NonTerminalName.EXPRESSION)) {
											System.out.print(nonTerm.getName() + "(" + ++rightCount + ")" + " ");
										} else {
											System.out.print(nonTerm.getName() + " ");
										}
									}
								}
								System.out.println();
							} else {
								System.out.println("          " + topNonTerminal.getName() + "(" + leftCount + ")" + " = epsilon");
								stack.pop();
							}

							if (rightCount > rightCountAux) {
								int aux = rightCount;
								while (aux > rightCountAux) {
									prodCount.push(aux--);
								}
							}

						} else {
							showSyntaticError(terminal.getTerminalToken());
						}
					}
				}
			}
		}
	}

	private void checkLinesToPrint() {
		if (previousToken != null) {
			if (!token.getValue().equals(previousToken.getValue())) {
				System.out.println(previousToken.toString());
				previousToken = null;
			}
		}
		
		if (!linesPrinted.contains(lexicalAnalyzer.getLine())) {
			linesPrinted.add(lexicalAnalyzer.getLine());
			System.out.println(lexicalAnalyzer.getLine().trim());
		}
	}

	private void showSyntaticError(Token token) {
		SyntaticAnalyzer.printError(token);
		System.exit(1);
	}
	
}
