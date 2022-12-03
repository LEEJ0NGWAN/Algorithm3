class 콜라츠추측 {
    
    public int solution(long num) {

        int answer = 0;
        
        while (1 != num) {
            
            num = num % 2 == 0? num/2: num*3+1;
            
            if (++answer == 500) return -1;
        }
        
        return answer;
    }
}