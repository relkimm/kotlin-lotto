package lotto.ui

class PaymentInput : UI {
    var value: String = ""
        private set

    override fun draw() {
        println("구입금액을 입력해 주세요.")
        this.value = readLine()!!
    }

    fun getPayment(): Int {
        return this.value.toIntOrNull() ?: throw IllegalStateException()
    }
}
