package domain

data class MineCount(val value: Int) {
    init {
        require(value >= 0) { "value must be positive number." }
    }

    fun increase(): MineCount {
        return copy(value = this.value + 1)
    }
}
