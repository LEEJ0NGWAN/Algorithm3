import java.util.Map;
import java.util.HashMap;

class Solution {

    public String[] solution(String[] players, String[] callings) {

        final Map<String, Integer> playerRanks = new HashMap<>();
        final Map<Integer, String> ranks = new HashMap<>();

        for (int i=0; i<players.length; i++) {

            playerRanks.put(players[i], i);
            ranks.put(i, players[i]);
        }

        for (final String calling: callings) {

            final int playerRank = playerRanks.get(calling);
            final String anotherPlayer = ranks.get(playerRank-1);

            playerRanks.put(calling, playerRank-1);
            playerRanks.put(anotherPlayer, playerRank);

            ranks.put(playerRank-1, calling);
            ranks.put(playerRank, anotherPlayer);

            players[playerRank-1] = calling;
            players[playerRank] = anotherPlayer;
        }

        return players;
    }
}
