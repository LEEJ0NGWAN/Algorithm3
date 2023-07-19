class Solution {

    private static int parseMinutes(String hhmm) {
        return
            ((hhmm.charAt(0)-'0')*10+hhmm.charAt(1)-'0')*60+
            (hhmm.charAt(3)-'0')*10+(hhmm.charAt(4)-'0');
    }

    private static String filterHash(String s) {

        final StringBuilder sb = new StringBuilder();
        for (int i=0,l=s.length()-1; i<l; i++)
        if (s.charAt(i)!='#')
        sb.append(s.charAt(i+1)=='#'? Character.toLowerCase(s.charAt(i)): s.charAt(i));

        if (s.charAt(s.length()-1)!='#') sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }

    public String solution(String m, String[] musicinfos) {

        final String target = filterHash(m);
        final StringBuilder sb = new StringBuilder();
        final java.util.Map<String, String> map = new java.util.HashMap<>();
        final java.util.Map<String, Integer> order = new java.util.HashMap<>();
        for (String info: musicinfos) {

            final String[] tokens = info.split(",");
            final int length = parseMinutes(tokens[1])-parseMinutes(tokens[0]);

            tokens[3] = filterHash(tokens[3]);
            
            if (length<= tokens[3].length()) tokens[3] = tokens[3].substring(0,length);
            else {

                sb.setLength(0);
                for (int i=0; i<length; sb.append(tokens[3].charAt(i++%tokens[3].length())));
                tokens[3] = sb.toString();
            }
            map.put(tokens[2], tokens[3]);
            order.put(tokens[2], map.size());
        }

        return map
            .entrySet()
            .stream()
            .filter(e -> e.getValue().contains(target))
            .sorted((a,b) -> b.getValue().length()==a.getValue().length()? order.get(a.getKey()).compareTo(order.get(b.getKey())): Integer.compare(b.getValue().length(), a.getValue().length()))
            .map(java.util.Map.Entry::getKey)
            .findFirst()
            .orElse("(None)");
    }
}
