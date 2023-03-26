class Solution {

    public String solution(String s) {

        final String[] tokens = s.split(" ");
        final String[] arr = { tokens[0], tokens[1] };

        for (final String token: tokens) {

            boolean minChange, maxChange;

            if (token.charAt(0)=='-') {

                minChange =
                    arr[0].charAt(0)!='-'||
                    token.length()>arr[0].length()||
                    (token.length()==arr[0].length()&&token.compareTo(arr[0])>0);
                maxChange =
                    arr[1].charAt(0)=='-'&&
                    (token.length()<arr[1].length()||
                    (token.length()==arr[1].length()&&token.compareTo(arr[1])<0));
            }
            else {

                minChange =
                    arr[0].charAt(0)!='-'&&
                    (token.length()<arr[0].length()||
                    (token.length()==arr[0].length()&&token.compareTo(arr[0])<0));
                maxChange =
                    arr[1].charAt(0)=='-'||
                    token.length()>arr[1].length()||
                    (token.length()==arr[1].length()&&token.compareTo(arr[1])>0);
            }
            if (minChange) arr[0] = token;
            if (maxChange) arr[1] = token;
        }

        return String.join(" ", arr);
    }
}
