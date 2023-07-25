package controller

import domain.Board
import domain.BoardSize
import domain.Height
import domain.MineCount
import domain.Positions
import domain.RandomNonNegativeNumberGenerator
import domain.Width
import presentation.InputView
import presentation.ResultView

fun main() {
    val boardSize = BoardSize(
        Width(InputView.getWidth()),
        Height(InputView.getHeight()),
    )
    val mineCount = MineCount(InputView.getMineCount())

    val minePositions = RandomNonNegativeNumberGenerator(
        to = boardSize.numberOfSpaces,
        count = mineCount.value,
    )
        .generate()
        .let { Positions.convertToPositions(it, boardSize.width) }

    val board = Board.create(boardSize, minePositions)
    ResultView.printBoard(board)
}
