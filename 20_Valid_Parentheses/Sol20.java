public class Sol20 {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();

        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("([{[[{}]()]}])"));
        System.out.println(validParentheses.isValid("()[]{[(}[]()}"));

    }
}
