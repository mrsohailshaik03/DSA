// LeetCode Problem 20: Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.
// Every close bracket has a corresponding open bracket of the same type.

import java.util.Stack;
public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') { //Opening bracket
                stack.push(ch);
            } else {
                // Closing bracket
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') 
                || (ch == '}' && top != '{')
                || (ch == ']' && top != '[')) {
                    return false;
                }
            }
            
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        String s = "{[]}";
        System.out.println(vp.isValid(s));
    }
}
