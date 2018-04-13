package calculatrice;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculatrice {
	
	private String userInput;
	private String[] userInputList;
	private int result;

	private ArrayList<Integer> numberList = new ArrayList<Integer>();
	private ArrayList<String> operatorList = new ArrayList<String>();
	
	public void calculate() {
		/**
		 * Calculate the operation entered by the user, use spaces to separate numbers and operators
		 * use "x" to multiply
		 * example : "2 + 5", "3 x 4"
		 */
		getUserInput();		

		while (operatorList.size()>0) {
			// find priority operations, calculate and put the results in a new list
			// find the first priority operator (x or /), if one found stop and calculate, if not, use the first operator
			int index = 0;
			for(String operatorInList : operatorList) {
				// if it's a priority operator, we use it for the next calculation
				// if not, we keep looking in the list 
				if ("*".equals(operatorInList) || "/".equals(operatorInList)) {
					break;
				}
				// if we reach the last element without finding any priority operator, we use the first element
				if (index == operatorList.size()-1) {
					index = 0;
					break;
				}
				index++;
			}
			// calculate and place the result at the index
			// get the values to use for the calculation
			result = 0;
			int firstValue = numberList.get(index);
			int secondValue = numberList.get(index+1);
			String operator = operatorList.get(index);
			if("+".equals(operator)) {add(firstValue, secondValue);}
			else if("-".equals(operator)) {minus(firstValue, secondValue);}
			else if("*".equals(operator)) {multiply(firstValue, secondValue);}
			else if("/".equals(operator)) {divide(firstValue, secondValue);}

			// remove the values used and set the result at the index position
			numberList.remove(index);
			numberList.set(index, result);
			operatorList.remove(index);
		}
		// print out the result
		System.out.println(numberList.get(0));
	}

	public void getUserInput(){
		/**
		 * get the user input from a scanner 
		 */
		Scanner scanner = new Scanner(System.in);
		userInput = scanner.nextLine();
		scanner.close();

		userInputStringToList();

		sortUserInputInList();
	}

	public void userInputStringToList() {
		/**
		 * use the spaces to separate the numbers and operators and list them in userInputList
		 */
		userInputList = userInput.split("\\s+");
		
	}

	public void sortUserInputInList() {
		/**
		 * separates numbers and operators from userInputList, list them in 2 different lists
		 */
		numberList.clear();
		operatorList.clear();

		int value;
		String operator;

		// put all the numbers or operators in either list
		for(String arg : userInputList) {
			// check if it's a number
			try {
				value = Integer.parseInt(arg);
				numberList.add(value);
				continue;
			}
			catch (NumberFormatException  e) {
			}
			// check if it's an operator
			if("+".equals(arg)) {operator = "+"; operatorList.add(operator);}
			else if("-".equals(arg)) {operator = "-"; operatorList.add(operator);}
			else if("x".equals(arg)) {operator = "*"; operatorList.add(operator);}
			else if("/".equals(arg)) {operator = "/"; operatorList.add(operator);}
			else {
				if("*".equals(arg)) {
					System.out.println(arg + " is not a valid operator");
					System.out.println("use 'x' to multiply");
				}
				else{System.out.println(arg + " is not a valid operator");}
				continue;
			}
		}
		// DEBUG print out the resulting lists
//		System.out.println(numberList);
//		System.out.println(operatorList);
	}

	public int add(int a, int b) {
		/**
		 * do a + b, and place the result in result
		 */
		result = a+b;
		return result;
	}

	public int minus(int a, int b) {
		/**
		 * do a - b, and place the result in result
		 */
		result = a-b;
		return result;
	}

	public int multiply(int a, int b) {
		/**
		 * do a * b, and place the result in result
		 */
		result = a*b;
		return result;
	}

	public int divide(int a, int b) {
		/**
		 * do a / b, and place the result in result
		 */
		if(b!=0) {
			result = a/b;
			return result;
		}
		else {
			System.out.println("Can not divide by 0");
			result = 0;
			return result;
		}
	}
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
