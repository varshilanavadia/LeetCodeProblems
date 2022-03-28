import java.util.*;

public class CourseSchedule {

    // Topological Sorting
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] p: prerequisites){
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> topOrder = new ArrayList<>();

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int next: graph[curr]){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
            topOrder.add(curr);
        }


        return topOrder.size() == numCourses ? topOrder.stream().mapToInt(Integer::valueOf).toArray() : new int[0];
    }
}
