package uz.hamroev.multimediatizim.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.hamroev.multimediatizim.R
import uz.hamroev.multimediatizim.adapter.ProvinceAdapter
import uz.hamroev.multimediatizim.cache.Cache
import uz.hamroev.multimediatizim.databinding.FragmentHomeBinding
import uz.hamroev.multimediatizim.model.Province
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentHomeBinding
    private lateinit var list: ArrayList<Province>
    lateinit var provinceAdapter: ProvinceAdapter
    private val TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        checkLanguage()
        loadProvince()

        provinceAdapter = ProvinceAdapter(
            binding.root.context,
            list,
            object : ProvinceAdapter.OnProvinceClickListener {
                override fun onClick(province: Province, position: Int) {
                    when (position) {
                        
                    }
                }
            })
        binding.rvRegions.adapter = provinceAdapter

        return binding.root
    }

    private fun checkLanguage() {
        Log.d(TAG, "checkLanguage: ${Cache.language}")
        when (Cache.language) {
            "uz" -> {
                setAppLocale(requireContext(), "en")
            }
            "ru" -> {
                setAppLocale(requireContext(), "ru")
            }
            "krill" -> {
                setAppLocale(requireContext(), "uz")
            }
        }
    }
    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(
            config,
            context.resources.displayMetrics
        )
    }

    private fun loadProvince() {
        list = ArrayList()
        list.add(Province(resources.getString(R.string.tashkent), R.drawable.ic_tashkent))
        list.add(Province(resources.getString(R.string.bukhara), R.drawable.ic_bukhara))
        list.add(Province(resources.getString(R.string.andijon), R.drawable.ic_andijon))
        list.add(Province(resources.getString(R.string.fergana), R.drawable.ic_ferghana))
        list.add(Province(resources.getString(R.string.jizzax), R.drawable.ic_jizzax))
        list.add(Province(resources.getString(R.string.xorazm), R.drawable.ic_xorazm))
        list.add(Province(resources.getString(R.string.namangan), R.drawable.ic_namangan))
        list.add(Province(resources.getString(R.string.navoiy), R.drawable.ic_navoiy))
        list.add(Province(resources.getString(R.string.qashqadaryo), R.drawable.ic_qashqadaryo))
        list.add(Province(resources.getString(R.string.qoraqalpogiston), R.drawable.ic_qaroqalpogiston))
        list.add(Province(resources.getString(R.string.samarqand), R.drawable.ic_samarkand))
        list.add(Province(resources.getString(R.string.sirdaryo), R.drawable.ic_sirdayo))
        list.add(Province(resources.getString(R.string.surxandaryo), R.drawable.ic_surxandaryo))
        list.add(Province(resources.getString(R.string.tashkent_viloyat), R.drawable.ic_tashkent_vil))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}