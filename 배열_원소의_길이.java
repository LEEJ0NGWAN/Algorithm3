class Solution {

    public int[] solution(String[] strlist) {

        return  java.util.Arrays
            .stream(strlist)
            .mapToInt(String::length)
            .toArray();
    }
}
