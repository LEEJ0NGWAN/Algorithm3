class Solution {

    public int[] solution(String msg) {

        final java.util.List<Integer> list = new java.util.ArrayList<>();
        final java.util.Map<String,Integer> map = new java.util.HashMap<>();
        for (char c='A'; c<='Z'; map.put(String.valueOf(c++), map.size()+1));

        int i=1, length=msg.length();
        while (--i<length) {

            String prev=null, next="";
            while (i<length&&map.containsKey(next+=msg.charAt(i++))) prev = next;
            list.add(map.get(prev));
            if (prev!=next) map.put(next, map.size()+1); else break;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
