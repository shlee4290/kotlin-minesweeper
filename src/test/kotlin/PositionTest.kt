import domain.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `인접한 좌표 판별 테스트`() {
        assertThat(
            Position(1, 1).isAdjacentWith(Position(1, 0))
        ).isTrue()
    }

    @Test
    fun `인접하지 않은 좌표 판별 테스트`() {
        assertThat(
            Position(1, 1).isAdjacentWith(Position(3, 3))
        ).isFalse()
    }

    @Test
    fun `동일한 좌표는 인접하지 않은 것으로 처리`() {
        assertThat(
            Position(1, 1).isAdjacentWith(Position(1, 1))
        ).isFalse()
    }
}
