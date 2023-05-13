class Solution {

    public int solution(int[] priorities, int location) {

        int answer=0, pivot=9;
        final int[] count = new int[10];
        for (int priority: priorities) count[priority]++;
        while (count[pivot]==0&&pivot-->0);
        for (int i=0; i<priorities.length; i=++i%priorities.length)
        if (priorities[i]==pivot) {
            ++answer; priorities[i]=0;
            if (i==location) break;
            if (--count[pivot]==0) while (count[pivot]==0&&pivot-->0);
        }

        return answer;
    }
}
