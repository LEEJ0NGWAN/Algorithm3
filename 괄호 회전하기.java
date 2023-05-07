class Solution {

    public int solution(String s) {

        final int length = s.length();
        final int[] stack = new int[length];
        final char[] window = (s+s).toCharArray();

        int pivot=-1, answer=0;

        for (int i=0, j=0; i<length&&i+j<window.length; i++) {

            final char c = window[i+j];
            final int type = c>='{'? 3: c>='['? 2: 1;
            final boolean open = c=='('||c=='['||c=='{';

            if (open) stack[++pivot] = type;
            else {

                if (pivot!=-1&&stack[pivot]==type) { if (--pivot==-1) answer++; }
                else { pivot=i=-1; answer=0; j++; }
            }
        }

        return answer;
    }
}
