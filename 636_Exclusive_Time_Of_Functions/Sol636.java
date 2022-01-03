import java.util.Arrays;

public class Sol636 {
    public static void main(String[] args) {
        ExclusiveTime exclusiveTime = new ExclusiveTime();

        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"))));
        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(1, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"))));
        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(2, Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"))));
    }
}
