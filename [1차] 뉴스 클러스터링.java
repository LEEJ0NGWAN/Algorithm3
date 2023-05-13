import java.util.Map;
import java.util.HashMap;
class Solution {

    private static final int MOD = 65536;

    private void subSet(Map<String, Integer> map, String string, int i) {

        final boolean a = Character.isLetter(string.charAt(i-1));
        final boolean b = Character.isLetter(string.charAt(i));

        if (!a||!b) return;
        final String subSet = string.substring(i-1,i+1).toLowerCase();
        System.out.println(subSet);
        map.put(subSet, map.getOrDefault(subSet,0)+1);
    }
    private int innerSize(Map<String,Integer> map1, Map<String,Integer> map2) {

        final Map<String,Integer> less = map1.size()<map2.size()? map1: map2;
        final Map<String,Integer> many = less==map1? map2: map1;

        int size = 0;
        for (String key: less.keySet()) if (many.containsKey(key))
        size += Math.min(less.get(key), many.get(key));

        return size;
    }
    private int unionSize(Map<String,Integer> map1, Map<String,Integer> map2) {

        final Map<String,Integer> less = map1.size()<map2.size()? map1: map2;
        final Map<String,Integer> many = less==map1? map2: map1;

        int size = 0;
        for (String key: less.keySet())
        if (many.containsKey(key)) size+=Math.max(map1.get(key),map2.get(key));
        else size+=less.get(key);
        for (String key: many.keySet())
        if (!less.containsKey(key)) size += many.get(key);
        
        return size;
    }
    public int solution(String str1, String str2) {

        final Map<String, Integer> map1 = new HashMap<>();
        final Map<String, Integer> map2 = new HashMap<>();

        for (int i=1, l=Math.max(str1.length(),str2.length()); i<l; i++) {

            if (i<str1.length()) subSet(map1, str1, i);
            if (i<str2.length()) subSet(map2, str2, i);
        }

        if (map1.isEmpty()&&map2.isEmpty()) return MOD;

        final int inner = innerSize(map1, map2);
        final int union = unionSize(map1, map2);

        return (int)(((float)inner/union)*MOD);
    }
}
