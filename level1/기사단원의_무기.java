class 기사단원의_무기 {
    
    public int solution(int number, int limit, int power) {

        int answer = 1;

        for (int i=2, c=0; i<=number;
             i++, answer+=c<=limit? c: power, c=0)
        for (int j=1, l=(int)Math.sqrt(i); j<=l;
             c+=i%j==0? j*j==i? 1:2:0, j++);

        return answer;
    }
}
