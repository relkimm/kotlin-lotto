package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `Lotto는 발급받은 로또의 번호들을 보관한다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val expected = setOf(
            LottoNumber[1],
            LottoNumber[2],
            LottoNumber[3],
            LottoNumber[4],
            LottoNumber[5],
            LottoNumber[6],
        )

        assertThat(lotto.numbers).isEqualTo(expected)
    }

    @Test
    fun `Lotto의 숫자가 6개가 아니면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.from(1, 2, 3, 4, 5)
        }
    }

    @Test
    fun `getNumberOfMatches를 통해 두 로또가 몇 개의 번호가 겹치는지 확인할 수 있다`() {
        val lotto1 = Lotto.from(1, 2, 3, 4, 5, 7)
        val lotto2 = Lotto.from(1, 2, 3, 4, 5, 6)

        assertThat(lotto1.getNumberOfMatches(lotto2)).isEqualTo(NumberOfMatches(5))
    }

    @Test
    fun `in 키워드를 통해 LottoNumber가 Lotto에 포함되는지 확인할 수 있다`() {
        val winningNumbers = Lotto.from(1, 2, 3, 4, 5, 6)

        assertThat(LottoNumber[1] in winningNumbers).isEqualTo(true)
        assertThat(LottoNumber[8] in winningNumbers).isEqualTo(false)
    }
}