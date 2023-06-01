class Solution {

    private static final java.util.regex.Pattern pattern =
        java.util.regex.Pattern.compile("(\\D+)(\\d+)(.*)");

    public String[] solution(String[] files) {

        return java.util.Arrays
            .stream(files)
            .map(pattern::matcher)
            .filter(matcher -> matcher.find())
            .map(matcher -> new Object[] { matcher.group(1).toLowerCase(), Integer.parseInt(matcher.group(2)), matcher.group() })
            .sorted((a,b) -> {

                final int headCompare = ((String)a[0]).compareTo((String)b[0]);
                if (headCompare!=0) return headCompare;

                return ((Integer)a[1]).compareTo((Integer)b[1]);
            })
            .map(arr -> (String)arr[2])
            .toArray(String[]::new);
    }
}
