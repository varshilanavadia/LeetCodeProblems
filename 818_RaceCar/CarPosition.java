import java.util.*;

class RaceCar {
    static class CarPosition {
        int speed, pos;
        public CarPosition(int pos, int speed){
            this.speed = speed;
            this.pos = pos;
        }

        public CarPosition() {

        }
    }

    public static int racecar(int target) {
        int minLen = Integer.MAX_VALUE;
        Queue<CarPosition> q = new LinkedList<>();
        int len = 0;
        CarPosition start = new CarPosition(0, 1);
        q.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(0 + "." + 1);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                CarPosition curr = q.poll();
                int pos = curr.pos;
                int speed = curr.speed;
                if(pos == target){
                    return len;
                }

                String s1 = (pos + speed) + "." + (speed << 1);
                String s2 = (pos) + "." + (speed > 0 ? -1 : 1);

                if(Math.abs(pos + speed - target) < target && !visited.contains(s1)){
                    q.offer(new CarPosition(pos+speed, speed << 1));
                    visited.add(s1);
                }
                if(Math.abs(pos - target) < target && !visited.contains(s2)){
                    q.offer(new CarPosition(pos, speed > 0 ? -1 : 1));
                    visited.add(s2);
                }
            }
            len++;
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            System.out.println(i + " -> " + racecar(i));
        }
    }
}