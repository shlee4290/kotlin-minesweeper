package domain

data class Positions(private val list: List<Position>) {

    fun forEach(action: (Position) -> Unit) {
        list.forEach(action)
    }

    companion object {
        fun convertToPositions(values: List<Int>, width: Width): Positions {
            return Positions(
                values.map { Position.convertToPosition(it, width) }
            )
        }
    }
}
