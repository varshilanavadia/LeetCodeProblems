import java.util.Arrays;
import java.util.List;

public class Sol332 {
    public static void main(String[] args) {
        FindItinerary findItinerary = new FindItinerary();

        List<List<String>> destinations = Arrays.asList(
                Arrays.asList("JFK","KUL"),
                Arrays.asList("NRT","JFK"),
                Arrays.asList("JFK","NRT")
                );
        System.out.println(findItinerary.findItinerary_iterativeDFS(destinations));
        System.out.println(findItinerary.findItinerary_recursiveDFS(destinations));

        destinations = Arrays.asList(
            Arrays.asList("MUC","LHR"),
            Arrays.asList("JFK","MUC"),
            Arrays.asList("SFO","SJC"),
            Arrays.asList("LHR","SFO")
        );
        System.out.println(findItinerary.findItinerary_iterativeDFS(destinations));
        System.out.println(findItinerary.findItinerary_recursiveDFS(destinations));

        destinations = Arrays.asList(
                Arrays.asList("JFK","SFO"),
                Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),
                Arrays.asList("ATL","JFK"),
                Arrays.asList("ATL","SFO")
        );
        System.out.println(findItinerary.findItinerary_iterativeDFS(destinations));
        System.out.println(findItinerary.findItinerary_recursiveDFS(destinations));
    }
}
