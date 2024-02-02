class Solution {

    public int[] solution(int[] arr) {

        return java.util.stream.IntStream
            .range(0, arr.length)
            .map(index-> {

                if (arr[index]>=50 && arr[index]%2==0)
                return arr[index]/=2;

                if (arr[index]< 50 && arr[index]%2==1)
                return arr[index]*=2;

                return arr[index];
            })
            .toArray();
    }
}
