package uz.mahmudovdev.exchange_rate.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("cb_price")
	val cbPrice: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("nbu_buy_price")
	val nbuBuyPrice: String? = null,

	@field:SerializedName("nbu_cell_price")
	val nbuCellPrice: String? = null
)
