class Solution {

    public int[] solution(int n, long k) {

        final int[] arr = new int[n];
		    final java.util.List<Integer> list = new java.util.ArrayList<>();
        long num=1; int idx=0;
        for (int x=1; x<=n; list.add(x), num*=x++); k--;

        while (idx<arr.length) {

        	int i = (int)(k/(num/=n--));
        	arr[idx++] = list.get(i);
        	list.remove(i);
        	k %= num;
        }
        return arr;
    }
}
