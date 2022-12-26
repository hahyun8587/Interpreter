package edu.handong.csee.plt;

import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.ParseException;

public class Main {
	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				System.out.println(
						"usage: java <Path to Main.class> [-p] <your code>.");
				System.exit(1);
			}		
			Parser parser = new Parser();

			if (args.length == 2) {
				System.out.println(parser.parse(args[1]).getASTCode());
			} else {
				System.out.println(
						new Interpreter().interprete(
								parser.parse(args[0]), 
								null, null).getASTCode());
			}
		} catch (ParseException | InterpreteException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
