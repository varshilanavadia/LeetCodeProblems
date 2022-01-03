import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(String token : tokens){
            if(!isOperator(token)){
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(token){
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token){
        return token.equals("+") || token.equals("*") || token.equals("/") || token.equals("-");
    }
}
