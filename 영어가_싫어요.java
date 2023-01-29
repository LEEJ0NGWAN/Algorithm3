class Solution {

    public long solution(String numbers) {

        final StringBuilder sb = new StringBuilder();

        final java.util.regex.Matcher matcher =
            java.util.regex.Pattern
            .compile("(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine)|(zero)")
            .matcher(numbers);

        while (matcher.find()) for (int i=1; i<=10; i++)
        if (matcher.group(i)!=null) sb.append((i+=10)%10);

        return Long.parseLong(sb.toString());
    }
}
