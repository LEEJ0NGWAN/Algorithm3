class Solution {

    public int[] solution(int[] sequence, int k) {

        for (int length=1, check=0, start=0, sum=start=sequence[length-1];
             length<sequence.length;
             sum=(start+=sequence[length++]))
            if ((check+=sequence[sequence.length-length])>=k)
                if (sum==k) return new int[] {0,length-1};
                else
                    for (int i=0,l=sequence.length-length; i<l; i++)
                    if ((sum+=sequence[i+length]-sequence[i])==k)
                    return new int[] {i+1,i+length};
        return new int[] {0,sequence.length-1};
    }
}
