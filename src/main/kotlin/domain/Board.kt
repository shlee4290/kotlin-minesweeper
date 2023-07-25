package domain

data class Board(
    private val boardSize: BoardSize,
    private val rows: List<Spaces>,
    private val minePositions: Positions,
) {

    init {
        plantMines()
    }

    val numberOfRow: Int = rows.size

    fun forEach(action: (Spaces) -> Unit) {
        rows.forEach(action)
    }

    private fun plantMines() {
        minePositions.forEach {
            rows[it.y].plantMineAt(it.x)
        }

        boardSize.allPositions().forEach { position ->
            setMineCount(position)
        }
    }

    private fun setMineCount(position: Position) {
        minePositions.forEach { minePosition ->
            increaseMineCountIfAdjacent(position, minePosition)
        }
    }

    private fun increaseMineCountIfAdjacent(position: Position, minePosition: Position) {
        if (position.isAdjacentWith(minePosition)) {
            increaseMineCountAt(position)
        }
    }

    private fun increaseMineCountAt(position: Position) {
        rows[position.y].increaseMineCountAt(position.x)
    }

    companion object {
        fun create(boardSize: BoardSize, minePositions: Positions): Board {
            return Board(
                boardSize,
                List(boardSize.height.value) {
                    Spaces.emptySpaces(boardSize.width.value)
                },
                minePositions
            )
        }
    }
}
