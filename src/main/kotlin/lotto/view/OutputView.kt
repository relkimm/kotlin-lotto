package lotto.view

import lotto.model.LottoResult
import lotto.model.LottoTickets

class OutputView {
    companion object {
        fun printTickets(tickets: LottoTickets) {
            println("${tickets.size}개를 구매했습니다.")
            tickets.forEach { println(it) }
        }

        fun printResult(result: LottoResult) {
            println("당첨 통계")
            result.winningCounter.forEach { (lottoPlace, count) ->
                println("${lottoPlace.winningCount}개 일치 (${lottoPlace.winnings.amount}원)- ${count}개")
            }
            println("총 수익률은 ${result.benefitRate}입니다.")
        }
    }
}