class Solution {

    public String solution(int[] numbers) {

        return java.util.stream.IntStream
            .of(numbers)
            .mapToObj(String::valueOf)
            .sorted((a,b)-> (b+a).compareTo(a+b))
            .collect(StringBuilder::new, (sb,s)->{ if(sb.length()==0||sb.charAt(0)!='0') sb.append(s); }, (sb1,sb2)->{})
            .toString();
    }
}
