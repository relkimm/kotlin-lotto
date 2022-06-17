package lotto.view

import lotto.domain.LottoGameResult
import lotto.domain.Rank

object LottoGameView {

    fun printPurchaseAmountInput() {
        println(PURCHASE_AMOUNT_MESSAGE)
    }

    fun printBuyAmount(n: Int) {
        println(n.toString() + BUY_AMOUNT_MESSAGE)
    }

    fun printLastWinningNumbers() {
        println(LAST_WINNING_NUMBER_MESSAGE)
    }

    fun printBonusNumber() {
        println(BONUS_NUMBER_MESSAGE)
    }

    fun printWinningStats(result: LottoGameResult) {
        println(
            """
            |$WINNING_STAT_MESSAGE
            |${Rank.values().take(MAX_RANK).reversed().joinToString("\n") { prizeMessageTemplate(result.ranks, it) }}
            |${createProfitMessage(result.profit)}
            """.trimMargin()
        )
    }

    private const val MAX_RANK = 5
    private const val PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    private const val BUY_AMOUNT_MESSAGE = "개를 구매했습니다."
    private const val LAST_WINNING_NUMBER_MESSAGE = "지난 주 당첩 번호를 입력해 주세요."
    private const val BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
    private const val WINNING_STAT_MESSAGE = "당첨 통계\n---------"
    private val prizeMessageTemplate = { ranks: List<Rank>, rank: Rank ->
        "${getRankMessage(rank)} - ${ranks.count { it == rank }}개"
    }
    private const val BONUS_MESSAGE = ", 보너스 볼 일치"
    private val createProfitMessage = { profit: Double ->
        "총 수익률은 ${profit}입니다." + getProfitResultMessage(profit)
    }

    private fun getRankMessage(rank: Rank): String {
        var matchMessage = "${rank.countOfMatch}개 일치"
        if (rank.matchedBonus) matchMessage += BONUS_MESSAGE
        return matchMessage + " (${rank.prize.toInt()}원)"
    }

    private fun getProfitResultMessage(profit: Double): String {
        return if (profit > 1.0) {
            "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)"
        } else if (profit < 1.0) {
            "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        } else {
            "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)"
        }
    }
}