import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result1 = groupAnagrams.groupAnagrams1(strs);
        System.out.println(result1);

    }
}
