import java.util.Set;
import java.util.HashSet;

class 옹알이 {
    
    // 조카 네 가지 발음 set
    private static final Set<String> set = new HashSet<>();
    static {

        set.add("aya"); set.add("ye"); set.add("woo"); set.add("ma");
    }
    
    // 주어진 str은 조카 네 가지 발음으로 구성 가능한가? yes: 1, no: 0
    public static int isValid(String str) {

        String cache = null;

        final StringBuilder sb = new StringBuilder();

        for (char c: str.toCharArray()) {
            
            sb.append(c);
            
            if (sb.length() == 2 || sb.length() == 3) {
                
                final String tmp = sb.toString();
                
                if (set.contains(tmp) && !tmp.equals(cache)) {
                    
                    sb.setLength(0);
                    cache = tmp;
                }
            }
            
            else if (sb.length() > 3) return 0;
        }

        return sb.length() == 0? 1: 0;
    }

    public int solution(String[] babbling) {
        
        int count = 0;
        
        for (String b: babbling) count += isValid(b);
        
        return count;
    }
}