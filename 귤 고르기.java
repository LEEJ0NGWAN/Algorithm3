class Solution {

    public int solution(int k, int[] tangerine) {

        final java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

        for (int size: tangerine) map.put(size,map.containsKey(size)? map.get(size)+1:1);

        final java.util.List<Integer> list =
        map
        .entrySet()
        .stream()
        .sorted((a,b)->b.getValue().compareTo(a.getValue()))
        .collect(()->new java.util.ArrayList<Integer>(), (l,e)->l.add(e.getValue()), (a,b)->{});

        int i=0; while((k-=list.get(i++))>0);

        return i;
    }
}
