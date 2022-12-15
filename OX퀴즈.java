import static java.util.Arrays.stream;
import java.util.regex.Pattern;

class OX퀴즈 {

    public String[] solution(String[] quiz) {

        final Pattern pattern =
        Pattern.compile("([-]?[0-9]+) ([+-]) ([-]?[0-9]+) = ([-]?[0-9]+)");

        return stream(quiz)
            .map(pattern::matcher)
            .filter(matcher -> matcher.find())
            .map(matcher -> {

                final int a = Integer.parseInt(matcher.group(1));
                final int b = Integer.parseInt(matcher.group(3));
                final int c = Integer.parseInt(matcher.group(4));

                return ("+".equals(matcher.group(2))? a+b==c: a-b==c)? "O": "X";
            })
            .toArray(String[]::new);
    }
}
