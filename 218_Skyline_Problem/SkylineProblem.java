import java.util.*;
import java.util.stream.Collectors;

public class SkylineProblem {
    public static List<List<Integer>> getSkyline(List<List<Integer>> buildings) {
        List<List<Integer>> skyline = new ArrayList<>();
        int n = buildings.size();
        if(n == 0){
            return skyline;
        }
        if(n == 1){
            int xLeft = buildings.get(0).get(0);
            int xRight = buildings.get(0).get(1);
            int y = buildings.get(0).get(1);
            skyline.add(Arrays.asList(xLeft, y));
            skyline.add(Arrays.asList(xRight, 0));
            return skyline;
        }

        List<List<Integer>> leftSkyline = getSkyline(buildings.subList(0, n/2));
        List<List<Integer>> rightSkyline = getSkyline(buildings.subList(n/2, n));

        return merge(leftSkyline, rightSkyline);
    }

    private static List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right){
        int i = 0, j = 0, nl = left.size(), nr = right.size();
        int x, maxY;
        int leftY = 0, rightY = 0, currY = 0;

        List<List<Integer>> result = new ArrayList<>();

        while(i < nl && j < nr){
            List<Integer> pLeft = left.get(i);
            List<Integer> pRight = right.get(j);

            if(pLeft.get(0) < pRight.get(0)){
                x = pLeft.get(0);
                leftY = pLeft.get(1);
                i++;
            } else {
                x = pRight.get(0);
                rightY = pRight.get(1);
                j++;
            }

            maxY = Math.max(leftY, rightY);

            if(maxY != currY){
                updateResult(result, x, maxY);
                currY = maxY;
            }
        }
        appendSkyline(result, left, i, nl, currY);
        appendSkyline(result, right, j, nr, currY);

        return result;
    }

    private static void updateResult(List<List<Integer>> result, int x, int y){
        if(result.size() == 0 || result.get(result.size()-1).get(0) != x){
            result.add(Arrays.asList(x, y));
        } else {
            result.get(result.size() - 1).set(1, y);
        }
    }

    private static void appendSkyline(List<List<Integer>> result, List<List<Integer>> list, int i, int n, int y){
        while(i < n){
            List<Integer> point = list.get(i);

            if(y != point.get(1)){
                updateResult(result, point.get(0), y);
                y = point.get(1);
            }

            i++;
        }
    }





    // APPROACH 2
    public static List<List<Integer>> getSkyline_usingHeap(List<List<Integer>> buildings){
        List<int[]> heights = new ArrayList<>();
        for(List<Integer> b :buildings){
            heights.add(new int[]{b.get(0), b.get(2)});
            heights.add(new int[]{b.get(1), -b.get(2)});
        }
        heights.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<List<Integer>> skyline = new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);
        int prevMaxHeight = 0;

        for(int[] b: heights){
            int x = b[0], y = b[1];
            if(y > 0){
                maxHeap.offer(y);
            } else {
                maxHeap.remove(-y);
            }

            int currHeight = maxHeap.peek();
            if(currHeight != prevMaxHeight){
                skyline.add(Arrays.asList(x, currHeight));
                prevMaxHeight = currHeight;
            }
        }
        return skyline;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? new ArrayList<>() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int buildingsLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> buildings = new ArrayList<>();
        for (int i = 0; i < buildingsLength; i++) {
            buildings.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        List<List<Integer>> res = getSkyline_usingHeap(buildings);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}

/*
5
2 9 10
3 7 15
5 12 12
15 20 10
19 24 8


* */
