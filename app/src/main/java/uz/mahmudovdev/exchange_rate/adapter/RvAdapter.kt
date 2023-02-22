package uz.mahmudovdev.exchange_rate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.mahmudovdev.exchange_rate.databinding.LayoutRvItemBinding
import uz.mahmudovdev.exchange_rate.model.ExchangeModel
import uz.mahmudovdev.exchange_rate.model.Response

class RvAdapter : RecyclerView.Adapter<RvAdapter.VH>() {
    val exchangeList = ArrayList<Response>()

    inner class VH(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(exchanger: Response) {
            binding.title.text = exchanger.title
            binding.code.text = exchanger.code
            binding.cbPrice.text = exchanger.cbPrice
            binding.nbuCellPrice.text = exchanger.nbuCellPrice
            binding.nbuBuyPrice.text = exchanger.nbuBuyPrice

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        LayoutRvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = exchangeList.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val exchanger = exchangeList[position]
        holder.onBind(exchanger)
    }

    fun refreshData(list: ArrayList<Response>) {
        exchangeList.clear()
        exchangeList.addAll(list)
        notifyDataSetChanged()
    }
}