class Solution {

    private static final int MAX = 1000000;

    public int solution(int price) {

        float rate = 1.0f;

        if (MAX*0.5 <= price) rate = 0.8f; else
        if (MAX*0.3 <= price) rate = 0.9f; else
        if (MAX*0.1 <= price) rate = 0.95f;

        return (int)(price * rate);
    }
}
