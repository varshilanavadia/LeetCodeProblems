import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(stack.isEmpty() && map.containsKey(c)){
                return false;
            }
            if(map.containsKey(c) && stack.peek() == map.get(c)){
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
