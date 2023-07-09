package domain

data class Board(
    private val rows: List<Spaces>,
) {

    val numberOfRow: Int = rows.size

    fun forEach(action: (Spaces) -> Unit) {
        rows.forEach(action)
    }

    fun plantMines(minePositions: Positions) {
        minePositions.forEach {
            rows[it.y].plantMineAt(it.x)
        }
    }

    companion object {
        fun create(boardSize: BoardSize): Board {
            return Board(
                List(boardSize.height.value) {
                    Spaces.emptySpaces(boardSize.width.value)
                }
            )
        }
    }
}
