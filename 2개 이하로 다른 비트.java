class Solution {

    public long[] solution(long[] numbers) {

        return java.util.stream.LongStream
            .of(numbers)
            .mapToObj(Long::toBinaryString)
            .mapToLong(bin -> {

                final int size = bin.length();
                if (bin.charAt(size-1)=='0')
                return Long.parseLong(bin.substring(0,size-1)+"1", 2);

                int index = -1;
                for (int i=size-1; i>0; i--)
                if (bin.charAt(i-1)=='0'&&bin.charAt(i)=='1') {

                    index = i; break;
                }

                if (index!=-1)
                return Long.parseLong(bin.substring(0,index-1)+"10"+bin.substring(index+1,size), 2);

                return Long.parseLong("10"+bin.substring(1), 2);
            })
            .toArray();
    }
}
