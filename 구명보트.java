class Solution {

    public int solution(int[] people, int limit) {

        final int[] weights = new int[limit+1];

        int pair = 0, left = limit, right = 0;

        for (final int w: people)
        if (w <= limit) { weights[w]++; right = Math.max(right,w); left = Math.min(left,w); }

        while (left<=right) {

            final boolean zeroRight = weights[right]==0;
            final boolean zeroLeft = weights[left]==0;
            final boolean bigSum = left+right>limit;

            if (zeroRight||zeroLeft||bigSum)
            { if (zeroRight||bigSum) right--; if (zeroLeft) left++; continue; }
            if (left==right) { pair += weights[left]/2; break; }

            final int many = weights[left]>=weights[right]? left: right;
            final int less = (left+right)-many;

            weights[many] -= weights[less]; pair += weights[less];
            if (less==left) left++; else right--;
        }
        return pair+(people.length-2*pair);
    }
}
