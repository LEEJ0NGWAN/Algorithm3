class 푸드_파이터_대회 {

    public String solution(int[] food) {
        
        final StringBuilder buffer = new StringBuilder();
        final StringBuilder builder = new StringBuilder();

        for (int i=1; i<food.length; i++)
        if  (food[i] > 1)
        for (int j=0, l=food[i]/2; j<l; j++)
            buffer.append(i);

        builder.append(buffer);
        builder.append(0); buffer.reverse();
        builder.append(buffer);
        
        return builder.toString();
    }
}
