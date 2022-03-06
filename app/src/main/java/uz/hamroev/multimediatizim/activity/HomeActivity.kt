package uz.hamroev.multimediatizim.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.hamroev.multimediatizim.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}