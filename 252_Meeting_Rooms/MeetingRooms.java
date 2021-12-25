import java.util.*;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1])
                return false;
        }

        return true;
    }

    public int minMeetingRooms_1(int[][] intervals) {
        if (intervals.length == 0) return 0;

        PriorityQueue<Integer> scheduler = new PriorityQueue(
                intervals.length, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        }
        );

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        scheduler.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= scheduler.peek()) {
                scheduler.poll();
            }
            scheduler.add(intervals[i][1]);
        }

        return scheduler.size();
    }

    public int minMeetingRooms_2(int[][] intervals) {
        if(intervals.length == 0) return 0;

        List<Integer> startTimes = new ArrayList();
        List<Integer> endTimes = new ArrayList();

        for(int[] interval : intervals){
            startTimes.add(interval[0]);
            endTimes.add(interval[1]);
        }

        startTimes.sort(Integer::compare);
        endTimes.sort(Integer::compare);
        // Collections.sort(startTimes);
        // Collections.sort(endTimes);

        int i = 0, j = 0, minRooms = 0;

        while(i < intervals.length){
            if(startTimes.get(i) >= endTimes.get(j)){
                minRooms--;
                j++;
            }
            minRooms++;
            i++;
        }

        return minRooms;
    }
}