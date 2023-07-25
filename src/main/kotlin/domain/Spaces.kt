package domain

class Spaces(private val spaces: MutableList<Space>) {

    fun list(): List<Space> {
        return spaces.toList()
    }

    fun plantMineAt(index: Int) {
        spaces[index] = Space.Mine()
    }

    fun increaseMineCountAt(index: Int) {
        with(spaces[index]) {
            if (this is Space.Empty) {
                spaces[index] = increaseMineCount()
            }
        }
    }

    fun openAt(index: Int): Boolean {
        spaces[index] = spaces[index].open()
        return spaces[index] is Space.Mine
    }

    companion object {
        fun emptySpaces(size: Int): Spaces {
            return Spaces(
                MutableList(size) { Space.Empty() }
            )
        }
    }
}
