import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트_게임 {

    public int solution(String dartResult) {
        
        final int[] scores = new int[4];
        
        final Pattern pattern = Pattern.compile("([0-9]{1,2})([SDT])([*#]?)");
        final Matcher matcher = pattern.matcher(dartResult);

        int i = 1;
        while (matcher.find()) {
            
            final String n = matcher.group(1);
            final String b = matcher.group(2);
            final String o = matcher.group(3);

            scores[i] = Integer.valueOf(n);

            if (b.equals("D")) scores[i] *= scores[i];
            else if (b.equals("T")) scores[i] = scores[i] * scores[i] * scores[i];
            
            if ("*".equals(o)) { scores[i-1] *= 2; scores[i] *= 2; }
            else if ("#".equals(o)) scores[i] *= -1;

            i++;
        }
        
        return scores[1] + scores[2] + scores[3];
    }
}
