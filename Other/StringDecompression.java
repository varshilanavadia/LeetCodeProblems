public class StringDecompression {
    public String stringDecompression(String str){
        StringBuilder sb = new StringBuilder();
        decompress(str, 0, sb);
        return sb.toString();
    }

    private int decompress(String str, int index, StringBuilder sb) {
        StringBuilder current = new StringBuilder();
        StringBuilder times = new StringBuilder();

        int i = index;
        while(i < str.length()){
            while(Character.isDigit(str.charAt(i))){
                times.append(str.charAt(i));
                i++;
            }

            if(str.charAt(i) == '[' && times.length() > 0){
                if(current.length() > 0){
                    sb.append(current);
                    current = new StringBuilder();
                }

                i = decompress(str, i+1, current);

                int repeatNumber = Integer.parseInt(times.toString());
                for (int j = 0; j < repeatNumber; j++) {
                    sb.append(current);
                }
                current = new StringBuilder();
                times = new StringBuilder();
            } else if (str.charAt(i) == ']') {
                return i + 1;
            } else {
                sb.append(str.charAt(i));
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        StringDecompression object = new StringDecompression();

        System.out.println(object.stringDecompression("10[a]"));
        System.out.println(object.stringDecompression("2[3[a]b]"));
        System.out.println(object.stringDecompression("2[a2[b2[c]]]"));
        System.out.println(object.stringDecompression("0[a]"));
        System.out.println(object.stringDecompression("a[]b"));
    }
}