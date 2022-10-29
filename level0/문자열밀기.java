class 문자열밀기 {

    public int solution(String A, String B) {

        final int length = A.length();
        final char[] window = new char[length * 2];

        for (int i = 0; i < window.length; i++) window[i] = A.charAt(i%length);

        for (int i = length; i > 0; i--)
        if  (String.copyValueOf(window,i,length).equals(B))
        return length - i;

        return -1;
    }
}