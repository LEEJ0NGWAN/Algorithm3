import java.util.Arrays;

public class 스킬트리 {

    public long solution(String skill, String[] skill_trees) {

        final String antiRegex = String.join(skill, "[^", "]*");

        return Arrays
            .stream(skill_trees)
            .map(tree -> tree.replaceAll(antiRegex, ""))
            .filter(tree -> skill.substring(0, tree.length()).equals(tree))
            .count();
    }
}
