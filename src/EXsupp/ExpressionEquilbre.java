package EXsupp;

import java.util.Stack;

public class ExpressionEquilbre {
    public static boolean estEquilibre(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char openDelimiter = stack.pop();
                if ((c == ')' && openDelimiter != '(') ||
                    (c == ']' && openDelimiter != '[') ||
                    (c == '}' && openDelimiter != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static int trouverPremierDelimiteurIncorrect(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return i; // Return index if there is no matching opening delimiter
                } 
                else {
                    char openDelimiter = stack.pop();
                    if ((c == ')' && openDelimiter != '(') ||
                        (c == ']' && openDelimiter != '[') ||
                        (c == '}' && openDelimiter != '{')) {
                        return i; // Return index if incorrect closing delimiter found
                    }
                }
            }
        }


    

        return -1; // Return -1 if no incorrect delimiter found
    }
}
