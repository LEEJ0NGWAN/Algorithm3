class Solution {

    public int solution(int bridge_length, int weight, int[] trucks) {

        int answer=0, index=0;
        boolean trucksOnBridge=false;

        final int[] bridge = new int[bridge_length];
        while (index<trucks.length||trucksOnBridge) {

            trucksOnBridge = false;
            for (int i=(weight+=bridge[0])*0+1; i<bridge_length; trucksOnBridge|=(bridge[i-1]=bridge[i++])!=0);

            bridge[bridge_length-1]=0;
            if (index<trucks.length&&trucks[index]<=weight) {

                trucksOnBridge = true;
                weight -= (bridge[bridge_length-1]=trucks[index++]);
            }
            

            answer++;
        }
        return answer;
    }
}
