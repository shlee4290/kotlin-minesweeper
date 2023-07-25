import domain.Board
import domain.BoardSize
import domain.Height
import domain.Positions
import domain.Width
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun `주어진 크기만큼 보드 생성되었는지 확인`() {
        val board = Board.create(
            BoardSize(
                Width(2),
                Height(3)
            ),
            Positions(emptyList())
        )

        board.forEach {
            assertThat(it.list()).size().isEqualTo(2)
        }

        assertThat(
            board.numberOfRow
        ).isEqualTo(3)
    }
}
