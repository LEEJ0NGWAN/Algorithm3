class Solution {

    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

        val resultMails = IntArray(id_list.size)
        val userIndex = id_list.mapIndexed{ index, id -> id to index }.toMap()
        val reportMap = mutableMapOf<String, MutableSet<String>>()

        report
        .map{ it.split(" ") }
        .forEach{ reportMap.getOrPut(it[1], { mutableSetOf() }).add(it[0]) }

        reportMap
        .values
        .filter{ it.size >= k }
        .flatMap{ it }
        .forEach{

            val index = userIndex.get(it)
            if (index != null)
            resultMails[index]++
        }

        return resultMails
    }
}
