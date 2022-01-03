import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
    class Log{
        int id, time;
        boolean isStart;

        public Log(String logEntry){
            String[] logDetails = logEntry.split(":");
            this.id = Integer.parseInt(logDetails[0]);
            this.isStart = logDetails[1].equals("start");
            this.time = Integer.parseInt(logDetails[2]);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack();
        int[] exclusiveTime = new int[n];

        for(String logEntry : logs){
            Log currentLog = new Log(logEntry);
            if(currentLog.isStart){
                stack.push(currentLog);
            } else {
                Log topLog = stack.pop();
                int executionTime = currentLog.time - topLog.time + 1;
                exclusiveTime[topLog.id] += executionTime;
                if(!stack.isEmpty()){
                    exclusiveTime[stack.peek().id] -= executionTime;
                }
            }
        }
        return exclusiveTime;
    }
}
