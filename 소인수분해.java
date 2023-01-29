class Solution {

    public int[] solution(int n) {

        final java.util.BitSet bitSet = new java.util.BitSet(n+1);

        bitSet.set(2,n+1);

        for (int i=2; i<=n; i++) if (bitSet.get(i))
        for (int j=i*2; j<=n; bitSet.set(j,false), j+=i);

        return bitSet.stream().filter(b -> n%b==0).toArray();
    }
}
