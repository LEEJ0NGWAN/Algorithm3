class Solution {

    public int solution(int[] elements) {

        final int length = elements.length;
        final java.util.Set<Integer> set = new java.util.HashSet<>();

        for (int i=0; i<length; i++)
        for (int j=0, sum=0; j<length;
             set.add(sum+=elements[(i+j++)%length]));

        return set.size();
    }
}
