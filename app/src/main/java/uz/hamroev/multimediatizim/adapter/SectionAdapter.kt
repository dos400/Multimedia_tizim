package uz.hamroev.multimediatizim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.multimediatizim.databinding.ItemSectionsBinding
import uz.hamroev.multimediatizim.model.Section

class SectionAdapter(
    var context: Context,
    var list: ArrayList<Section>,
    var onSectionClickListener: OnSectionClickListener
) :
    RecyclerView.Adapter<SectionAdapter.VhSections>() {

    inner class VhSections(var itemSectionsBinding: ItemSectionsBinding) :
        RecyclerView.ViewHolder(itemSectionsBinding.root) {

        fun onBind(section: Section, position: Int) {
            itemSectionsBinding.titleSection.text = section.sectionTitle
            itemSectionsBinding.imageSection.setImageResource(section.sectionImage)

            itemSectionsBinding.cardSection.setOnClickListener {
                onSectionClickListener.onClick(section, position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhSections {
        return VhSections(
            ItemSectionsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhSections, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnSectionClickListener {
        fun onClick(section: Section, position: Int)
    }
}