import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다항식더하기 {

    // (String)x -> (Integer)
    private static final Function<String, Integer> filter =
    x -> "".equals(x)? 1: Integer.valueOf(x);

    // (Integer)x -> (String)
    private static final Function<Integer, String> parser =
    x -> x==1? "": x.toString();

    public String solution(String polynomial) {

        final Pattern pattern = Pattern.compile("([0-9]*)(x)|([0-9]+)");
        final Matcher matcher = pattern.matcher(polynomial);

        Integer x = 0; Integer n = 0; // (x)x + (n)

        while (matcher.find())

        if (matcher.group(2) != null)
        x += filter.apply(matcher.group(1));

        else
        n += Integer.valueOf(matcher.group(3));

        final StringBuilder sb = new StringBuilder();

        if (x > 0) sb.append(parser.apply(x)).append("x");
        if (x > 0 && n > 0) sb.append(" + ");
        if (n > 0) sb.append(n);
        
        return sb.toString();
    }
}
