package edu.handong.csee.plt;

import java.util.ArrayList;
import java.util.Stack;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.InvalidSyntaxException;
import edu.handong.csee.plt.exception.ParenthesisNotMatchingExcpetion;
import edu.handong.csee.plt.exception.ParseException;
import edu.handong.csee.plt.exception.handler.parse.ParenthesisExceptionHandler;
import edu.handong.csee.plt.parse.NumParse;
import edu.handong.csee.plt.parse.Parse;

public class Parser {
	private Parse method;
	private ParenthesisExceptionHandler handler = new ParenthesisExceptionHandler();

	public AST parse(String code) throws ParseException, Exception {
		ArrayList<String> subExpressions = 
				splitExpressionAsSubExpressions(code);

		method = new NumParse();

		while (method != null) {
			AST ast = method.parse(this, subExpressions);
			
			if (ast != null) {
				return ast;
			}
		}
		throw new InvalidSyntaxException(code);
	}

	public ArrayList<String> splitExpressionAsSubExpressions(String code) 
			throws ParenthesisNotMatchingExcpetion {
		handler.handleException(code);

		if (code.startsWith("{"))
			code = code.substring(1, code.length() - 1);

		return getSubExpressions(code);
	}

	/**
	 * This method return a list of sub-expression from the given expression. For
	 * example, {+ 3 {+ 3 4} -> +, 3, {+ 3 4} 
	 * @param code code without outer parenthesis
	 * @return list of sub expressions
	 */
	private ArrayList<String> getSubExpressions(String code) {
		ArrayList<String> subExpressions = new ArrayList<>();
		Stack<Character> stack = new Stack<>();

		String strBuffer = "";

		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == ' ') {
				if (stack.isEmpty() && !strBuffer.isEmpty()) {
					subExpressions.add(strBuffer);

					strBuffer = "";
				} else if (!stack.isEmpty()) {
					strBuffer += code.charAt(i);
				}
			} else if (code.charAt(i) == '{') {
				stack.add(code.charAt(i));

				strBuffer += code.charAt(i);
			} else if (code.charAt(i) == '}') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
				strBuffer += code.charAt(i);
			} else {
				strBuffer += code.charAt(i);
			}
		}
		subExpressions.add(strBuffer);

		return subExpressions;
	}

	public void setMethod(Parse method) {
		this.method = method;
	}

	/**
     * Checks whether the given string is numeric or not.
     * @param str string 
     * @return true if the given string is numeric, otherwise false
     */
    public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	/**
	 * Checks whether the given string is alphabetic or not.
	 * @param str string
	 * @return true if the given string is alphabetic, otherwise false
	 */
	public static boolean isAlphabetic(String str) {
		return str.matches("[a-zA-Z]+");
    }

	/**
	 * Checks whether the given string is expression or not.
	 * @param str string
	 * @retrun true if the given stringis expression, otherewise false
	 */
	public static boolean isExpression(String str) {
		return str.matches("^\\{.+\\}$");
	}
}
