import java.util.*;

public class AlienDict {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String w: words){
            for(char c: w.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                char c = word1.charAt(j);
                char d = word2.charAt(j);
                if(c != d){
                    graph.get(c).add(d);
                    indegree.put(d, indegree.get(d) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c: indegree.keySet()){
            if(indegree.get(c) == 0){
                queue.offer(c);
            }
        }


        while(!queue.isEmpty()){
            Character curr = queue.poll();
            for(Character next: graph.get(curr)){
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0){
                    queue.offer(next);
                }
            }
            sb.append(curr);
        }

        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}