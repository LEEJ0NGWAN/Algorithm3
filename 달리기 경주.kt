class Solution {

    fun solution(players: Array<String>, callings: Array<String>): Array<String> {

        val playerRank = mutableMapOf<String, Int>()
        val rankPlayer = mutableMapOf<Int, String>()

        players
        .forEachIndexed{
            i, p ->
            playerRank[p] = i
            rankPlayer[i] = p
        }

        callings
        .forEach{
            
            val rank = playerRank[it]!!
            val other = rankPlayer[rank-1]!!

            playerRank[it] = rank-1
            playerRank[other] = rank
            rankPlayer[rank] = other
            rankPlayer[rank-1] = it
        }

        return playerRank
        .toList()
        .sortedBy{ (k,v) -> v }
        .map{ (k,v) -> k }
        .toTypedArray()
    }
}
