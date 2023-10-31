class Solution {

    val dy = intArrayOf(-1,0,1,0)
    val dx = intArrayOf(0,1,0,-1)
    val dr = "NESW"

    fun solution(park: Array<String>, routes: Array<String>): IntArray {

        val h = park.size
        val w = park[0].length

        var now = intArrayOf(0,0)
        for (i in 0 until park.size)
        for (j in 0 until park[0].length)
        if (park[i][j]=='S')
        now = intArrayOf(i,j)

        routes
        .map{ it.split(" ") }
        .forEach{

            val dir = dr.indexOf(it[0])
            val dis = it[1].toInt()

            var tmp = intArrayOf(now[0], now[1])

            var mobile = true
            for (i in 1..dis) {

                tmp[0]+=dy[dir]
                tmp[1]+=dx[dir]

                if (
                    tmp[0] !in 0 .. h-1 ||
                    tmp[1] !in 0 .. w-1 ||
                    park[tmp[0]][tmp[1]]=='X') {

                    mobile = false
                    break
                }
            }

            if (mobile) now = tmp
        }

        return now
    }
}
