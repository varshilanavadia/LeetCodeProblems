import java.util.Arrays;

public class Sol127 {
    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();

        System.out.println(wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

    }
}
