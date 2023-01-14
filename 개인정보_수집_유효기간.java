import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;
import java.util.ArrayList;
import java.util.Map;

class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {

        final Map<String, Integer> map =
            stream(terms)
            .map(s -> s.split(" "))
            .collect(toMap(t->t[0], t->Integer.valueOf(t[1])));
        
        final ArrayList<Integer> result = new ArrayList<>();

        for (int i=0; i<privacies.length; i++) {

            final String[] tokens = privacies[i].split(" ");
            final String[] dates = tokens[0].split("[.]");

            int y = Integer.parseInt(dates[0]);
            int m = Integer.parseInt(dates[1]);
            int d = Integer.parseInt(dates[2]);

            y += (map.get(tokens[1])/12);
            m += (map.get(tokens[1])%12);
            
            if (m > 12) { y+=m/12; m%=12; }
            if (--d==0) { d=28; --m; }

            final String ymd = String.format("%d.%02d.%02d",y,m,d);

            if (today.compareTo(ymd) > 0) result.add(i+1);
        }

        return result.stream().mapToInt(a->a).toArray();
    }
}
