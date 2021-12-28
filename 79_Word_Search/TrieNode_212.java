import java.util.HashMap;
import java.util.Map;

public class TrieNode_212 {
    Map<Character, TrieNode_212> neighbours;
    boolean isWord;

    public TrieNode_212(boolean isWord){
        neighbours = new HashMap();
        this.isWord = isWord;
    }
}