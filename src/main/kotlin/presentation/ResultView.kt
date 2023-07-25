package presentation

import domain.Board
import domain.Spaces
import domain.Space

object ResultView {
    fun printBoard(board: Board) {
        board.forEach {
            printRow(it)
        }
    }

    private fun printRow(spaces: Spaces) {
        spaces.list().forEach {
            printSpace(it)
        }
        println()
    }

    private fun printSpace(space: Space) {
        if (!space.isOpen) {
            print("C")
            print(" ")
            return
        }
        when (space) {
            is Space.Mine -> print("*")
            is Space.Empty -> print(space.numberOfMine)
        }
        print(" ")
    }
}
