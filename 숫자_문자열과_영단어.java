import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.function.Function;

class 숫자_문자열과_영단어 {
    
    private static Map<String, String> map = new HashMap<>();
    static {

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
    }

    private static final Function<String, String> parse =
    string -> map.containsKey(string)? map.get(string): string;

    public int solution(String s) {

        final Pattern pattern = Pattern.compile(
            "(zero)|(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine)|([0-9]+)");
        
        final Matcher matcher = pattern.matcher(s);
        final StringBuilder sb = new StringBuilder();
        
        while (matcher.find()) sb.append(parse.apply(matcher.group()));
        
        return Integer.valueOf(sb.toString());
    }
}