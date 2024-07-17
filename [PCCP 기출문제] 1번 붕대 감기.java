class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {

        final int healDuration = bandage[0];
        final int healRate = bandage[1];
        final int healExtraPoint = bandage[2];

        int currentTime = 0;
        int currentHealth = health;

        for (final int[] attack: attacks) {

            final int attackTime = attack[0];
            final int attackDamage = attack[1];

            final int healTimeAmount = attackTime - currentTime - 1;

            currentHealth +=
                (healTimeAmount * healRate) +
                (healTimeAmount / healDuration) * healExtraPoint;

            currentHealth = Math.min(currentHealth, health);

            if ((currentHealth -= attackDamage) <= 0) return -1;
            else currentTime = attackTime;
        }

        return currentHealth;
    }
}
