package uz.hamroev.multimediatizim.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import uz.hamroev.multimediatizim.R
import uz.hamroev.multimediatizim.cache.Cache
import uz.hamroev.multimediatizim.databinding.ActivityHomeBinding

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

        Cache.init(this)
        supportActionBar?.hide()

        val navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)

        binding.cardMenu.setOnClickListener {
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
}