package uz.mahmudovdev.exchange_rate.model

class ExchangeModel(
    val code: String?,
    val alphaCode: String?,
    val numericCode: Int?,
    val name: String?,
    val rate: Double?,
    val date: String?,
    val inverseRate: Double?,
)