import java.util.*;

public class FindItinerary {

    // RECURSIVE DFS
    public List<String> findItinerary_recursiveDFS(List<List<String>> tickets) {
        LinkedList<String> itenerary = new LinkedList();

        if(tickets.size() == 0)
            return itenerary;

        Map<String, LinkedList<String>> graph = new HashMap();
        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0), new LinkedList<String>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        for(LinkedList<String> list : graph.values()){
            Collections.sort(list);
        }

        dfs(graph, itenerary, "JFK");

        return itenerary;
    }

    private void dfs(Map<String, LinkedList<String>> graph, LinkedList<String> itenerary, String city){
        if(graph.containsKey(city)){
            while(!graph.get(city).isEmpty()){
                dfs(graph, itenerary, graph.get(city).pollFirst());
            }
        }
        itenerary.offerFirst(city);

    }

    // ITERATIVE DFS
    public List<String> findItinerary_iterativeDFS(List<List<String>> tickets) {
        LinkedList<String> itenerary = new LinkedList();

        if(tickets.size() == 0)
            return itenerary;

        Map<String, LinkedList<String>> graph = new HashMap();
        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0), new LinkedList<String>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        for(LinkedList<String> list : graph.values()){
            Collections.sort(list);
        }

        Stack<String> stack = new Stack();
        stack.push("JFK");

        while(!stack.isEmpty()){
            while(graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()){
                stack.push(graph.get(stack.peek()).poll());
            }
            itenerary.offerFirst(stack.pop());
        }

        return itenerary;
    }
}
