package domain

data class BoardSize(val width: Width, val height: Height) {
    val numberOfSpaces: Int = width.value * height.value

    fun allPositions(): Positions {
        return width.indices().flatMap { x ->
            height.indices().map { y ->
                Position(x = x, y = y)
            }
        }.let {
            Positions(it)
        }
    }
}
