class Solution {

    public int[] solution(final String[] keyinput, final int[] board) {

        final int[] answer = { board[0]/2+1, board[1]/2+1 };

        for (final String key: keyinput)
        switch (key) {
            case "up": answer[1] = Math.min(answer[1]+1, board[1]); break;
            case "down": answer[1] = Math.max(answer[1]-1, 1); break;
            case "left": answer[0] = Math.max(answer[0]-1, 1); break;
            case "right": answer[0] = Math.min(answer[0]+1, board[0]); break;
        }

        answer[0]-=(board[0]/2+1); answer[1]-=(board[1]/2+1);

        return answer;
    }
}
