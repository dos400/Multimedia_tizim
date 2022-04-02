package uz.hamroev.multimediatizim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.multimediatizim.databinding.ItemProvinceBinding
import uz.hamroev.multimediatizim.model.Province

class ProvinceAdapter(
    var context: Context,
    var list: ArrayList<Province>,
    var onProvinceClickListener: OnProvinceClickListener
) :
    RecyclerView.Adapter<ProvinceAdapter.ViewHolder>() {

    inner class ViewHolder(var itemProvinceBinding: ItemProvinceBinding) :
        RecyclerView.ViewHolder(itemProvinceBinding.root) {

        fun onBind(province: Province, position: Int) {



            itemProvinceBinding.cardMain.setOnClickListener {
                onProvinceClickListener.onClick(province, position)
            }

            itemProvinceBinding.provinceName.text = province.provinceName

            try {
                itemProvinceBinding.provinceImage.setImageResource(province.provinceImage)
            } catch (e: Exception) {

            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProvinceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnProvinceClickListener {
        fun onClick(province: Province, position: Int)
    }
}