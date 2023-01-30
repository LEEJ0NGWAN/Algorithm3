class Solution {

    public int[] solution(int[] emergency) {

        final java.util.concurrent.atomic.AtomicInteger index =
            new java.util.concurrent.atomic.AtomicInteger(1-emergency.length);

        return java.util.Arrays
        .stream(emergency)
        .mapToObj(x -> new int[] {index.getAndIncrement(), x})
        .sorted((a,b) -> b[1]-a[1])
        .map(arr -> new int[] {arr[0], index.getAndIncrement()})
        .sorted((a,b) -> a[0]-b[0])
        .mapToInt(arr -> arr[1])
        .toArray();
    }
}
