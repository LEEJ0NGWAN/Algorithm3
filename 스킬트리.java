class Solution {

    public long solution(String skill, String[] skill_trees) {

        final String pattern = String.join(skill, "[^", "]");
        return java.util.Arrays
            .stream(skill_trees)
            .map(skill_tree -> skill_tree.replaceAll(pattern, ""))
            .filter(skill::startsWith)
            .count();
    }
}
