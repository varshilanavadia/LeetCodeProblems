import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        int length = 0;
        queue.offer(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();

                if(current.equals(endWord)){
                    return length+1;
                }

                List<String> nextWords = getNextWords(current);
                for(String next: nextWords){
                    if(words.contains(next)){
                        words.remove(next);
                        queue.offer(next);
                    }
                }
            }
            length++;
        }

        return 0;
    }

    private List<String> getNextWords(String word){
        List<String> nextWords = new ArrayList<>();
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            char temp = wordArray[i];
            for(char c = 'a'; c <= 'z'; c++){
                wordArray[i] = c;
                nextWords.add(new String(wordArray));
            }
            wordArray[i] = temp;
        }
        return nextWords;
    }
}
