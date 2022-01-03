public class Sol150 {
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();

        System.out.println(evalRPN.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
