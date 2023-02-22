class Solution {

    public int[] solution(int[] array) {

        int max=-1,index=0;

        for (int i=0; i<array.length; i++)
        if  (max<array[i]) max = array[(index=i)];

        return new int[] {max,index};
    }
}
