package uz.hamroev.multimediatizim.activity

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import uz.hamroev.multimediatizim.R
import uz.hamroev.multimediatizim.cache.Cache
import uz.hamroev.multimediatizim.databinding.ActivityHomeBinding
import uz.hamroev.multimediatizim.databinding.DialogLanguageBinding
import java.util.*

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    var isBack = false
    lateinit var handler: Handler
    var doubleToast = "Please click BACK again to exit"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        supportActionBar?.hide()

        val navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)

        binding.cardLanguage.setOnClickListener {
            val alertDialog = AlertDialog.Builder(binding.root.context)
            val dialog = alertDialog.create()
            val bindingLanguage =
                DialogLanguageBinding.inflate(LayoutInflater.from(applicationContext))
            dialog.setView(bindingLanguage.root)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(true)

            bindingLanguage.russian.setOnClickListener {
                Cache.language = "ru"
                navController.popBackStack()
                navController.navigate(R.id.homeFragment)
                dialog.dismiss()
            }
            bindingLanguage.krill.setOnClickListener {
                Cache.language = "krill"
                navController.popBackStack()
                navController.navigate(R.id.homeFragment)
                dialog.dismiss()
            }
            bindingLanguage.uzb.setOnClickListener {
                Cache.language = "uz"
                navController.popBackStack()
                navController.navigate(R.id.homeFragment)
                dialog.dismiss()
            }


            dialog.show()

        }

        binding.cardMenu.setOnClickListener {
            checkLanguage()
            binding.drawerLayout.open()
        }




    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }


    override fun onBackPressed() {


        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else
            if (isBack) {
                super.onBackPressed()
                return
            }

        this.isBack = true
        handler = Handler(Looper.getMainLooper())
        Toast.makeText(this, "$doubleToast", Toast.LENGTH_SHORT).show()
        handler.postDelayed({
            isBack = false
        }, 1000)
    }

    private fun checkLanguage() {
        when (Cache.language) {
            "uz" -> {
                setAppLocale(this, "en")
            }
            "ru" -> {
                setAppLocale(this, "ru")
            }
            "krill" -> {
                setAppLocale(this, "uz")
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

}