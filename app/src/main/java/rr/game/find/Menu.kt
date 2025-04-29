package rr.game.find

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import rr.game.find.databinding.MenuBinding
import rr.game.find.`fun`.Constant
import rr.game.find.levels.Level3

class Menu : AppCompatActivity() {

    private var health = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val healthPoint = binding.healthPoint

        binding.buttonStart.setOnClickListener {
            startActivity(
                Intent(this@Menu, Level3::class.java)
                    .apply {
                        putExtra(Constant.HEALTH_GIVE, health)
                    }

            )
            finish()
        }

        binding.moreHealth.setOnClickListener {
            health++
            healthPoint.text = health.toString()
        }

        binding.bottomExit.setOnClickListener {
            Toast.makeText(
                this,
                R.string.goodbye,
                Toast.LENGTH_LONG
            )
                .show()
            finish()
        }
    }
}