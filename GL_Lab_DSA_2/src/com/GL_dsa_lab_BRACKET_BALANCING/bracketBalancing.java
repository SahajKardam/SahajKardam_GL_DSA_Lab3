package com.GL_dsa_lab_BRACKET_BALANCING;
import java.util.Scanner;
import java.util.Stack;
public class bracketBalancing {
	    public static boolean isBalanced(String str) {
	        Stack<Character> stack = new Stack<>();
	        for (int i = 0; i < str.length(); i++) {
	            char c = str.charAt(i);
	            if (c == '(' || c == '[' || c == '{') {
	                stack.push(c);
	            } else if (c == ')' || c == ']' || c == '}') {
	                if (stack.isEmpty()) {
	                    return false;
	                }
	                char top = stack.pop();
	                if (c == ')' && top != '(') {
	                    return false;
	                }
	                if (c == ']' && top != '[') {
	                    return false;
	                }
	                if (c == '}' && top != '{') {
	                    return false;
	                }
	            }
	        }
	        return stack.isEmpty();
	    }

	    public static void main(String[] args) {
	    	//String str = "( [ [ { } ] ] )";
	    	//String str = "( [ [ { } ] ] ) )";
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter a string containing brackets : ");
	         String str = scanner.nextLine();
	         
	         	if (isBalanced(str)) {
	         		System.out.println("The entered string has balanced brackets.");
	         	} else {
	         		System.out.println("The entered string does not have balanced brackets.");
	         	}
	    }
	}

