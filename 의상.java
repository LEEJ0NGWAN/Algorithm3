class Solution {

    public int solution(String[][] clothes) {

        int answer = 1;
        final java.util.Map<String, Integer> map = new java.util.HashMap<>();
        for (String[] arr: clothes)
        map.put(arr[1], map.getOrDefault(arr[1], 0)+1);
        for (int count: map.values()) answer*=(++count);

        return --answer;
    }
}
