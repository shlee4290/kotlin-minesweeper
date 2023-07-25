package domain

class Spaces(private val spaces: MutableList<Space>) {

    fun list(): List<Space> {
        return spaces.toList()
    }

    fun plantMineAt(index: Int) {
        spaces[index] = Space.Mine
    }

    fun increaseMineCountAt(index: Int) {
        with(spaces[index]) {
            if (this is Space.Empty) increaseMineCount()
        }
    }

    companion object {
        fun emptySpaces(size: Int): Spaces {
            return Spaces(
                MutableList(size) { Space.Empty() }
            )
        }
    }
}
