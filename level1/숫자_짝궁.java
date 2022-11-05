public class 숫자_짝궁 {

    public String solution(String X, String Y) {
        
        final int[] x = new int[10];
        final int[] y = new int[10];

        for (char c: X.toCharArray()) x[c - '0']++;
        for (char c: Y.toCharArray()) y[c - '0']++;
        
        final StringBuilder sb = new StringBuilder();
        
        for (int i = 9; i > 0; i--) {
            
            if (x[i] == 0 || y[i] == 0) continue;
            
            for (int j = 0, l = Math.min(x[i], y[i]); j < l; j++) sb.append(i);
        }
        
        if (sb.length() == 0)
        return x[0] == 0 || y[0] == 0? "-1": "0";
        
        else
            if (x[0] != 0 && y[0] != 0)
            for (int i = 0, l = Math.min(x[0], y[0]); i < l; i++) sb.append(0);
        
        return sb.toString();
    }
}
