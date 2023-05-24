class Solution {

    private static final int MAX = 10000;
    private static final int maxMinutes = 24*60;

    public int[] solution(int[] fees, String[] records) {

        final int[] carParkingMinutes = new int[MAX];
        final int[] carInMinutes = new int [MAX];

        for (String r: records) {

            final String[] splited = r.split(" ");
            final String[] times = splited[0].split(":");

            final int carNumber = Integer.parseInt(splited[1]);
            final int minutes = 1+
                Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);

            if ("IN".equals(splited[2]))
                carInMinutes[carNumber] = minutes;
            else {
                final int diff = minutes - carInMinutes[carNumber];
                carParkingMinutes[carNumber] += diff;
                carInMinutes[carNumber] = 0;
            }
        }

        return java.util.stream.IntStream
            .range(0,MAX)
            .filter(n -> carParkingMinutes[n]!=0||carInMinutes[n]!=0)
            .map(n -> {

                if (carInMinutes[n]!=0)
                    carParkingMinutes[n] += (maxMinutes-carInMinutes[n]);

                int fee = fees[1];
                if (carParkingMinutes[n]>fees[0]) {

                    final int extraMinutes = carParkingMinutes[n] - fees[0];
                    fee +=
                        fees[3]*(int)Math.ceil((float)extraMinutes/fees[2]);
                }
                return fee;
            })
            .toArray();
    }
}
