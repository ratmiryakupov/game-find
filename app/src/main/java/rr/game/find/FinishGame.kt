package rr.game.find

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import rr.game.find.databinding.FinishGameBinding
import rr.game.find.`fun`.Constant

class FinishGame : AppCompatActivity() {

    private var totalScore: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FinishGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        score = intent.getIntExtra(Constant.SCORE_GIVE, 0)
        binding.textScore.text = score.toString()

        binding.buttonExit.setOnClickListener {
            finish()
        }
    }
}