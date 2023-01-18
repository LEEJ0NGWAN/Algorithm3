class Solution {

    public String solution(String[] id_pw, String[][] db) {
        
        return java.util.Arrays
            .stream(db)
            .filter(info -> info[0].equals(id_pw[0]))
            .findFirst()
            .map(info -> info[1].equals(id_pw[1])? "login": "wrong pw")
            .orElse("fail");
    }
}
