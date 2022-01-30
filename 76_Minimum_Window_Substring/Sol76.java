public class Sol76 {
    public static void main(String[] args) {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();

        System.out.println(minWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowSubstring.minWindow("aa", "a"));
        System.out.println(minWindowSubstring.minWindow("VaRkjdsfghssRasfhgRsHiL", "sss"));
        System.out.println(minWindowSubstring.minWindow("kjsdfhaklsfuhbahbckarufbaksdjfkasjdgkjasgdhkjasghirwncaksdjbfd", "kjds"));
    }
}
