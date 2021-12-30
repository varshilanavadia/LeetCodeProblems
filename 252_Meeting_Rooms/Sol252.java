public class Sol252 {
    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        int[][][] intervals = {{{0, 30}, {5, 10}, {15, 20}}, {{7, 10}, {2, 4}}, {}};

        for(int[][] interval : intervals){
            System.out.println(meetingRooms.canAttendMeetings(interval));
            System.out.println(meetingRooms.minMeetingRooms_1(interval));
            System.out.println(meetingRooms.minMeetingRooms_2(interval));
        }

    }
}
