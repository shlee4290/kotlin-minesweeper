package domain

sealed interface Space {
    object Mine : Space
    class Empty : Space {
        private var mineCount: MineCount = MineCount(0)

        val numberOfMine: Int
            get() = mineCount.value

        fun increaseMineCount() {
            mineCount = mineCount.increase()
        }
    }
}
