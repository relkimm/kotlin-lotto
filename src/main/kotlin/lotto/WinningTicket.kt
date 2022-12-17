package lotto

class WinningTicket private constructor(val lottoRank: LottoRank) {
    companion object {
        fun from(lottoTicket: LottoTicket): WinningTicket {
            require(lottoTicket.status.isWinStatus())
            val lottoRank = LottoRank.from(matchCount = lottoTicket.matchCount)
            return WinningTicket(lottoRank = lottoRank)
        }
    }
}