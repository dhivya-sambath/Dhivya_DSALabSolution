package com.greatlearning.lab3dsa;

import java.util.Stack;

public class BalancingBrackets {

	    public boolean checkBalancedBrackets(String expression)
	    {
	        
	        Stack<Character> stack = new Stack<Character>();
	 
	        for (int i = 0; i < expression.length(); i++)
	        {
	            char character = expression.charAt(i);
	 
	            if (character == '(' || character == '[' || character == '{')
	            {
	               
	                stack.push(character);
	                continue;
	            }
	 
	          
	            if (stack.isEmpty())
	                return false;
	            
	            char ch;
	            
	            switch (character) {
	            
	            case '}':
	            	
	            	ch = stack.pop();
	                if (ch == '(' || ch == '[')
	                    return false;
	                break;
	                
	            case ')':
	            	
	                ch = stack.pop();
	                if (ch == '{' || ch == '[')
	                    return false;
	                break;
	 
	            case ']':
	                ch = stack.pop();
	                if (ch == '(' || ch == '{')
	                    return false;
	                break;
	            }
	        }
	 
	       
	        return (stack.isEmpty());
	    }
	 
	    public static void main(String[] args)
	    {
	    	BalancingBrackets obj = new BalancingBrackets();
	    	
	        String expression = "([[{}]])";
	         
	        Boolean result;
	        
	        result = obj.checkBalancedBrackets(expression);
	        
	        if (result)
	        {
	            System.out.println("The entered String has Balanced Brackets");
	        }
	        else
	        {
	            System.out.println("The entered Strings do not contain Balanced Brackets ");
	        }
	    }
	}

