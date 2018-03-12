package com.company;

import com.company.operations.Multiplication;
import com.company.operations.Operations;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
		try {
			LineReader lineReader = new LineReader("input.txt");
			LineWriter lineWriter = new LineWriter("output.txt");
			String expression = lineReader.getNextLine();
			while (expression != null) {
				ParserOfLineWithExpression parser = new ParserOfLineWithExpression(expression);

				BigNumber number1 = parser.getNumber1();
				BigNumber number2 = parser.getNumber2();
				OperationType operationType = parser.getOperation();

				BigNumber result = Operations.calculate(number1, number2, operationType);

				String lineForWrite = expression + " = " + result.getAsString();

				System.out.println(lineForWrite);

				lineWriter.writeLine(lineForWrite);
				expression = lineReader.getNextLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
