class Solution {

    private static final java.util.HashMap<String, Character> map =
        new java.util.HashMap<String, Character>() {{

        put(".-", 'a'); put("-...", 'b'); put("-.-.", 'c');
        put("-..", 'd'); put(".", 'e'); put("..-.", 'f');
        put("--.", 'g'); put("....", 'h'); put("..", 'i');
        put(".---", 'j'); put("-.-", 'k'); put(".-..", 'l');
        put("--", 'm'); put("-.", 'n'); put("---", 'o');
        put(".--.", 'p'); put("--.-", 'q'); put(".-.", 'r');
        put("...", 's'); put("-", 't'); put("..-", 'u');
        put("...-", 'v'); put(".--", 'w'); put("-..-", 'x');
        put("-.--", 'y'); put("--..", 'z');
    }};

    public String solution(String letter) {

        final String[] tokens = letter.split(" ");

        return java.util.Arrays
            .stream(tokens)
            .map(map::get)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
