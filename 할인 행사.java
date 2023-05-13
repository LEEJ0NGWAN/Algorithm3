class Solution {

    private static final int size = 10;

    public int solution(String[] want, int[] number, String[] discount) {

        final java.util.Map<String, int[]> map = new java.util.HashMap<>();
        for (int i=0; i<want.length;
             map.put(want[i], new int[] {number[i++], 0}));

        int answer=0, rest=map.size();
        for (int i=0; i<size; i++)
        if ((number=map.get(discount[i]))!=null)
        if (number[0]==++number[1]&&--rest==0) ++answer;

        for (int i=size,j=0; i<discount.length; j=++i-size) {

            if (!discount[j].equals(discount[i])) {

                number = map.get(discount[j]);
                if (number!=null&&number[0]==number[1]--) ++rest;
                number = map.get(discount[i]);
                if (number!=null&&number[0]==++number[1]) --rest;
            }
            if (rest==0) ++answer;
        }
        return answer;
    }
}
