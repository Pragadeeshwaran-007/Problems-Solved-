class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char currChar : expression.toCharArray()) {

            if (currChar == ',' || currChar == '(') continue;

            if (currChar == 't' || currChar == 'f' ||
                currChar == '!' || currChar == '&' || currChar == '|') {
                stack.push(currChar);
            } 
            else if (currChar == ')') {

                boolean hasTrue = false;
                boolean hasFalse = false;

                while (stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                    char top = stack.pop();
                    if (top == 't') hasTrue = true;
                    if (top == 'f') hasFalse = true;
                }

                char op = stack.pop();

                if (op == '!') {
                    stack.push(hasTrue ? 'f' : 't');
                }
                if (op == '&') {
                    stack.push(hasFalse ? 'f' : 't');
                }
                if (op == '|') {
                    stack.push(hasTrue ? 't' : 'f');
                }
            }
        }
        return stack.peek() == 't';
    }
}
