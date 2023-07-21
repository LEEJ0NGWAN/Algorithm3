class Solution {

    private static final String ops = "+-*";
    private static final java.util.regex.Pattern pattern =
        java.util.regex.Pattern.compile("([-]?\\d+)(\\D?)");

    public static long foo(char op, long x, long y) {

        return op=='*'? x*y: op=='+'? x+y: x-y;
    }

    public static long dfs(String e, String order, long sum) {

        if (order.length()==ops.length()) {

            for (char op: order.toCharArray()) {

                final StringBuilder sb = new StringBuilder();
                final java.util.regex.Matcher matcher = pattern.matcher(e);
                if (!matcher.find()) continue;

                long prevNum = Long.parseLong(matcher.group(1));
                char prevOp = matcher.group(2).isEmpty()? 0: matcher.group(2).charAt(0);

                if (prevOp!=0)
                while (matcher.find()) {

                    final long nextNum = Long.parseLong(matcher.group(1));
                    if (prevOp==op) {

                        prevNum = foo(prevOp, prevNum, nextNum);
                    }
                    else {

                        sb.append(prevNum).append(prevOp);
                        prevNum = nextNum;
                    }
                    prevOp = matcher.group(2).isEmpty()? 0: matcher.group(2).charAt(0);
                }
                e = sb.append(prevNum).toString();
            }
            return Math.abs(Long.parseLong(e));
        }

        for (char op: ops.toCharArray())
        if (order.indexOf(op)==-1)
        sum = Math.max(sum, dfs(e, order+op, sum));

        return sum;
    }
    public long solution(String expression) {

        return dfs(expression, "", 0);
    }
}
