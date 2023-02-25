class Solution {

    public int[] solution(String[] keymap, String[] targets) {

        final int[] index = new int[26];

        for (final String key: keymap)
        key
        .chars()
        .reduce(1, (i,c) -> { if (index[c-65]==0||index[c-65]>i) index[c-65]=i; return i+1; });

        return java.util.Arrays
        .stream(targets)
        .mapToInt(target -> {

            int sum = 0;

            for (final char c: target.toCharArray())
            if  (index[c-65]==0) return -1; else sum += index[c-65];

            return sum;
        })
        .toArray();
    }
}
