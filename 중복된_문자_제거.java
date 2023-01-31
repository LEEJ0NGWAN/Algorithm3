class Solution {

    public String solution(String my_string) {

        final java.util.BitSet bitSet = new java.util.BitSet();

        return my_string
            .chars()
            .filter(c -> {

                if (bitSet.get(c)) return false;

                bitSet.set(c); return true;
            })
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
