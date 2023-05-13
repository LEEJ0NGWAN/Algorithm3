class Solution {

    private static final int max = 20;

    public boolean solution(String[] phone_book) {

        final boolean[] arr = new boolean[max+1];
        final java.util.Set<String> set = new java.util.HashSet<>();

        for (String phone: phone_book) arr[phone.length()] = set.add(phone);
        for (String phone: phone_book)
        for (int i=1, l=phone.length(); i<l; i++)
        if (arr[i]&&set.contains(phone.substring(0,i))) return false;

        return true;
    }
}
