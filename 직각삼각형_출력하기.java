public class Solution {

    public static void main(String[] args) throws Exception {

        final byte[] bytes = new byte[2];
        final int n = System.in.read(bytes)==2? 10: bytes[0]-48;

        final StringBuilder sb = new StringBuilder();

        for (int i=0; i< n; i++, sb.append('\n'))
        for (int j=0; j<=i; j++, sb.append('*'));

        System.out.print(sb);
    }
}
