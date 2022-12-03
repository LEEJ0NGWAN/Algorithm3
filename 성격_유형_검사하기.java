class 성격_유형_검사하기 {

    public String solution(String[] survey, int[] choices) {
        
        final int[] scores = new int[100];

        for (int i = 0; i < survey.length; i++)
        scores[survey[i].charAt(choices[i] < 4? 0: 1)] += Math.abs(choices[i] - 4);
        
        final StringBuilder sb = new StringBuilder();
        
        sb
        .append(scores['R'] >= scores['T']? 'R': 'T')
        .append(scores['C'] >= scores['F']? 'C': 'F')
        .append(scores['J'] >= scores['M']? 'J': 'M')
        .append(scores['A'] >= scores['N']? 'A': 'N');

        return sb.toString();
    }
}