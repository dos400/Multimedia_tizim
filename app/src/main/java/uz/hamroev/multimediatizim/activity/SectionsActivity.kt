package uz.hamroev.multimediatizim.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.hamroev.multimediatizim.R
import uz.hamroev.multimediatizim.adapter.SectionAdapter
import uz.hamroev.multimediatizim.cache.Cache
import uz.hamroev.multimediatizim.databinding.ActivitySectionsBinding
import uz.hamroev.multimediatizim.model.Section

class SectionsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySectionsBinding
    lateinit var list: ArrayList<Section>
    lateinit var sectionAdapter: SectionAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySectionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadTop()
        loadSectionsData()
        sectionAdapter = SectionAdapter(this, list, object : SectionAdapter.OnSectionClickListener {
            override fun onClick(section: Section, position: Int) {
                Toast.makeText(this@SectionsActivity, "скоро будет", Toast.LENGTH_SHORT).show()
            }
        })
        binding.rvSections.adapter = sectionAdapter

    }

    private fun loadSectionsData() {
        list = ArrayList()
        list.add(Section(resources.getString(R.string.sec_tarixiy), R.drawable.ic_history_doc))
        list.add(Section(resources.getString(R.string.sec_biografik), R.drawable.ic_biograph))
        list.add(Section(resources.getString(R.string.sec_normativ), R.drawable.ic_normativ))
        list.add(Section(resources.getString(R.string.sec_arxiv), R.drawable.ic_archive_doc))
        list.add(Section(resources.getString(R.string.sec_fototeka), R.drawable.ic_image))
        list.add(Section(resources.getString(R.string.sec_videoteka), R.drawable.ic_videos))
        list.add(Section(resources.getString(R.string.sec_loyiha_haqida), R.drawable.ic_app_about))
    }

    private fun loadTop() {
        binding.regionName.text = Cache.regionName

        when (Cache.regionName) {
            resources.getString(R.string.tashkent) -> {
                binding.regionImage.setImageResource(R.drawable.ic_tashkent)
            }
            resources.getString(R.string.bukhara) -> {
                binding.regionImage.setImageResource(R.drawable.ic_bukhara)

            }
            resources.getString(R.string.andijon) -> {
                binding.regionImage.setImageResource(R.drawable.ic_andijon)

            }
            resources.getString(R.string.fergana) -> {
                binding.regionImage.setImageResource(R.drawable.ic_ferghana)

            }
            resources.getString(R.string.jizzax) -> {
                binding.regionImage.setImageResource(R.drawable.ic_jizzax)

            }
            resources.getString(R.string.xorazm) -> {
                binding.regionImage.setImageResource(R.drawable.ic_xorazm)

            }
            resources.getString(R.string.namangan) -> {
                binding.regionImage.setImageResource(R.drawable.ic_namangan)

            }
            resources.getString(R.string.navoiy) -> {
                binding.regionImage.setImageResource(R.drawable.ic_navoiy)

            }
            resources.getString(R.string.qashqadaryo) -> {
                binding.regionImage.setImageResource(R.drawable.ic_qashqadaryo)

            }
            resources.getString(R.string.qoraqalpogiston) -> {
                binding.regionImage.setImageResource(R.drawable.ic_qaroqalpogiston)

            }
            resources.getString(R.string.samarqand) -> {
                binding.regionImage.setImageResource(R.drawable.ic_samarkand)

            }
            resources.getString(R.string.sirdaryo) -> {
                binding.regionImage.setImageResource(R.drawable.ic_sirdayo)

            }
            resources.getString(R.string.surxandaryo) -> {
                binding.regionImage.setImageResource(R.drawable.ic_surxandaryo)

            }
            resources.getString(R.string.tashkent_viloyat) -> {
                binding.regionImage.setImageResource(R.drawable.ic_tashkent_vil)

            }

        }
    }
}