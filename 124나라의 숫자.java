class Solution {

    private static final char[] arr = {'1','2','4'};
    public String solution(int n) {

        final StringBuilder sb = new StringBuilder();
        while (n>0) {

            sb.append(arr[--n%arr.length]);
            n/=arr.length;
        }
        return sb.reverse().toString();
    }
}
