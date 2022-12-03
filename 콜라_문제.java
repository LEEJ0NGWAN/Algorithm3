class 콜라_문제 {

    public int solution(int a, int b, int n) {

        int answer = 0, exchange = n - (n%a);

        while ((n = exchange + (n%a)) >= a)
        answer += (exchange = (n/a)*b);

        return answer;
    }
}
