package domain

import kotlin.math.abs

data class Position(val x: Int, val y: Int) {

    fun isAdjacentWith(other: Position): Boolean {
        if (this == other) return false

        val xDistance = abs(x - other.x)
        val yDistance = abs(y - other.y)

        return xDistance <= ADJACENT_THRESHOLD && yDistance <= ADJACENT_THRESHOLD
    }

    companion object {
        private const val ADJACENT_THRESHOLD = 1

        fun convertToPosition(value: Int, width: Width): Position {
            return Position(
                x = value % width.value,
                y = value / width.value,
            )
        }

        fun convertToPosition(pair: Pair<Int, Int>): Position {
            return Position(pair.first, pair.second)
        }
    }
}
