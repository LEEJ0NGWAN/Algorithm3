class Solution {

    private static final int max = 10000000;
    private static final java.util.BitSet bits = new java.util.BitSet();

    static {

        bits.set(2,max);
        for (int i=2; i<max; i++)
        if (bits.get(i))
        for (int j=i*2; j<max; bits.clear(j), j+=i);
    }

    private static int dfs(int current, char[] arr, int mask, java.util.Set<Integer> set) {

        if (bits.get(current)) set.add(current);
        for (int i=0; i<arr.length; i++)
        if ((mask&(1<<i))==0)
        dfs(current*10+arr[i]-'0', arr, mask|(1<<i), set);
        
        return set.size();
    }

    public int solution(String numbers) {

        return dfs(0,numbers.toCharArray(),0,new java.util.HashSet<Integer>());
    }
}
