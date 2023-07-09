package domain

class Spaces(private val spaces: MutableList<Space>) {

    fun list(): List<Space> {
        return spaces.toList()
    }

    fun plantMineAt(index: Int) {
        spaces[index] = Space.Mine
    }

    companion object {
        fun emptySpaces(size: Int): Spaces {
            return Spaces(
                MutableList(size) { Space.Empty }
            )
        }
    }
}
