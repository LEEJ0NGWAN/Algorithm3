class Solution {

    public String solution(String number, int k) {

        final StringBuilder sb = new StringBuilder();

        char max = 0;
        int index = 0, size = number.length()-k;
        while (size-->0) {

            for (int i=index, l=number.length()-size; i<l; i++)
            if (max < number.charAt(i)) {

                max = number.charAt(i);
                index = i+1;
            }
            sb.append(max);
            max = 0;
        }

        return sb.toString();
    }
}
