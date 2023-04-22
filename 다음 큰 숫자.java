  class Solution {

    public int solution(int n) {

        final char[] bits = "0".concat(Integer.toBinaryString(n)).toCharArray();

        boolean swap = false;
        int pivot=bits.length-1, moveCount = 0;

        while (pivot-->1)
        if ((swap = bits[pivot]=='0'&&bits[pivot+1]=='1')) {

            bits[pivot] ='1'; bits[pivot+1] ='0';
            break;
        }
        else if (bits[pivot+1]=='1') moveCount++;

        if (!swap) bits[0] = '1';

        for (int i=bits.length-1; pivot<i; bits[i--] = moveCount-->0? '1': '0');

        return Integer.parseInt(new String(bits),2);
    }
}
