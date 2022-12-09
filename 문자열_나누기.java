public class 문자열_나누기 {

    public int solution(String s) {

        int answer = 0;

        for(int x=0,y=0,i=0,l=s.length(); i<l; i++)
        if (y==0) x = s.charAt(i) + (answer += (y=1)) - answer;
        else y += x== s.charAt(i)? 1: -1;

        return answer;
    }
}
