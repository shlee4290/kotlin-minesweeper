package domain

data class Position(val x: Int, val y: Int) {
    companion object {
        fun convertToPosition(value: Int, width: Width): Position {
            return Position(
                x = value % width.value,
                y = value / width.value,
            )
        }
    }
}
