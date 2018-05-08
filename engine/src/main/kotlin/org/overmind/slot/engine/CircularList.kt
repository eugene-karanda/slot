package org.overmind.slot.engine

class CircularList<out T>(private val list: List<T>) : List<T> by list {

    override fun get(index: Int): T =
            list[index.safely()]

    override fun subList(fromIndex: Int, toIndex: Int): List<T> {
        return with(list) {
            if (toIndex > size) {
                val firstColumnPart = subList(fromIndex, size)
                val secondColumnPart = subList(0, toIndex - size)

                firstColumnPart + secondColumnPart
            } else {
                subList(fromIndex, toIndex)
            }
        }
    }

    private fun Int.safely(): Int =
            if (this < 0) (this % size + size) % size
            else this % size
}

fun <T> List<T>.circular(): CircularList<T> = CircularList(this)