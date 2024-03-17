package pl.borawski.lab2

class AlgorithmsImplementation {

    fun bubbleSort(list: MutableList<Int>): MutableList<Int>{
        var changes: Int = 0
        do {
            changes = 0
            var a = 0
            var size = list.size
            for (i in 0..size - 2){
                if(list.get(i) > list.get(i + 1) ){
                    var help = list.get(i + 1)
                    list.set(i + 1, list.get(i))
                    list.set(i, help)
                    changes++
                }
            }
        }while (changes != 0)
        println(list)
        return list
    }

    fun selectionSort(list: MutableList<Int>): MutableList<Int> {
        for (index in 0 until list.size - 1) {
            var minIndex = index
            for (j in index + 1 until list.size) {
                if (list[j] < list[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != index) {
                list.swap(minIndex, index)
            }
        }
        return list
    }
    private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }

}