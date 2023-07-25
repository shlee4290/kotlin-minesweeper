package domain

sealed interface Space {

    val isOpen: Boolean

    fun open(): Space

    data class Mine(override val isOpen: Boolean = false) : Space {
        override fun open(): Space {
            return copy(isOpen = true)
        }
    }

    data class Empty(
        override val isOpen: Boolean = false,
        private val mineCount: MineCount = MineCount(0),
    ) : Space {

        val numberOfMine: Int
            get() = mineCount.value

        fun increaseMineCount(): Empty {
            return copy(mineCount = mineCount.increase())
        }

        override fun open(): Space {
            return copy(isOpen = true)
        }
    }
}
