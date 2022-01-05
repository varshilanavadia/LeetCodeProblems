public class Sol72 {
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();

        System.out.println(editDistance.isOneEditDistance("ephra", "ephram"));
        System.out.println(editDistance.isOneEditDistance("sols", "sos"));
        System.out.println(editDistance.isOneEditDistance("green", "grean"));
        System.out.println(editDistance.isOneEditDistance("green", "greans"));

        System.out.println(editDistance.minDistance("benyam", "ephram"));
        System.out.println(editDistance.minDistance("ros", "horse"));
        System.out.println(editDistance.minDistance("varshil", "anavadia"));
    }
}
