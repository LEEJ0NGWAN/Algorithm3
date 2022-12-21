class Solution {

    public int[] solution(int num, int total) {

        final int[] arr = new int[num];

        if (total%num==0) {

            arr[num/2] = total/num;
            for (int i=num/2-1; i>=0; arr[i] = arr[i--+1]-1);
            for (int i=num/2+1; i<num; arr[i] = arr[i++-1]+1);
        }
        else {

            arr[num-1] = total/num+total%num;
            for (int i=num-2; i>=0; arr[i] = arr[i--+1]-1);
        }
        return arr;
    }
}
