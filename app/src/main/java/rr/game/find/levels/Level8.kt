package rr.game.find.levels

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import com.google.android.material.button.MaterialButton
import rr.game.find.FinishGame
import rr.game.find.MainActivity
import rr.game.find.`fun`.ImageChange
import rr.game.find.R
import rr.game.find.databinding.Level8Binding
import rr.game.find.`fun`.Constant
import java.util.Locale

class Level8 : AppCompatActivity() {
    private var ivChange: Int = 0
    private var ivChange1: Int = 0
    private var ivChange2: Int = 0
    private var ivChange3: Int = 0
    private var ivChange4: Int = 0
    private var ivChange5: Int = 0
    private var ivChange6: Int = 0
    private var ivChange7: Int = 0
    private var ivChange8: Int = 0
    private var healthPoint: Int = 3
    private var score: Int = 0
    private var listGame = mutableListOf<Int>()

    private var timerLimit: Long = 45000
    private var timeDelay: Long = 4000

    private var scoreFinish: Int = 0
    private var timeResult: Int = 0
    private var healthStart: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Level8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val res = binding.imageRestart
        val back = binding.back

        val iv = binding.imageChange
        val iv1 = binding.image1
        val iv2 = binding.image2
        val iv3 = binding.image3
        val iv4 = binding.image4
        val iv5 = binding.image5
        val iv6 = binding.image6
        val iv7 = binding.image7
        val iv8 = binding.image8

        val textTimer = binding.textTimer
        val health = binding.textHealth

        score = intent.getIntExtra(Constant.SCORE_GIVE, 0)
        healthStart = intent.getIntExtra(Constant.HEALTH_GIVE, 3)
        timeDelay = intent.getLongExtra(Constant.TIME_DELAY_GIVE, 5000)

        if (healthStart != 3) {
            healthPoint = healthStart
            health.text = healthPoint.toString()
        }

        textTimer.text =
            (String.format(
                Locale(""),
                "%02d:%02d", (timerLimit / 1000) / 60, (timerLimit / 1000) % 60
            )
                    )

        getImage()
        rndImageChange()

        val timer = object : CountDownTimer(timerLimit, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val min = (millisUntilFinished / 1000) / 60
                val sec = (millisUntilFinished / 1000) % 60

                textTimer.text =
                    (String.format(
                        Locale(""),
                        "%02d:%02d", min, sec
                    ))

                if (millisUntilFinished < 10000) {
                    textTimer.setTextColor(Color.RED)
                }

                timeResult = millisUntilFinished.toInt()
            }

            override fun onFinish() {
                textTimer.setText(R.string.time_over)
                healthPoint = 0
                health.text = "$healthPoint"
                health.setTextColor(Color.RED)
                lose()
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            iv1.setImageResource(ivChange1)
            iv2.setImageResource(ivChange2)
            iv3.setImageResource(ivChange3)
            iv4.setImageResource(ivChange4)
            iv5.setImageResource(ivChange5)
            iv6.setImageResource(ivChange6)
            iv7.setImageResource(ivChange7)
            iv8.setImageResource(ivChange8)
        }, 2000)

        Handler(Looper.getMainLooper()).postDelayed({
            timer.start()
            iv1.setImageResource(R.drawable.image000)
            iv2.setImageResource(R.drawable.image000)
            iv3.setImageResource(R.drawable.image000)
            iv4.setImageResource(R.drawable.image000)
            iv5.setImageResource(R.drawable.image000)
            iv6.setImageResource(R.drawable.image000)
            iv7.setImageResource(R.drawable.image000)
            iv8.setImageResource(R.drawable.image000)
            iv.setImageResource(ivChange)
        }, 2000 + timeDelay)

        res.setOnClickListener {
            restart()
        }

        back.setOnClickListener {
            startActivity(Intent(this@Level8, MainActivity::class.java))
            finish()
        }


        iv1.setOnClickListener {
            iv1.setImageResource(ivChange1)
            iv1.setEnabled(false)

            if (ivChange1 == ivChange) {
                if (listGame.isEmpty()) {
                    timer.cancel()
                    win()
                } else {
                    rndImageChange()
                    iv.setImageResource(ivChange)
                }
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    iv1.setImageResource(R.drawable.image000)
                    iv1.setEnabled(true)
                }, 1500)

                healthPoint--
                health.text = "$healthPoint"
                if (healthPoint == 0) {
                    timer.cancel()
                    lose()
                }
            }
        }

        iv2.setOnClickListener {
            iv2.setImageResource(ivChange2)
            iv2.setEnabled(false)

            if (ivChange2 == ivChange) {
                if (listGame.isEmpty()) {
                    timer.cancel()
                    win()
                } else {
                    rndImageChange()
                    iv.setImageResource(ivChange)
                }
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    iv2.setImageResource(R.drawable.image000)
                    iv2.setEnabled(true)
                }, 1500)

                healthPoint--
                health.text = "$healthPoint"
                if (healthPoint == 0) {
                    timer.cancel()
                    lose()
                }
            }
        }

        iv3.setOnClickListener {
            iv3.setImageResource(ivChange3)
            iv3.setEnabled(false)

            if (ivChange3 == ivChange) {
                if (listGame.isEmpty()) {
                    timer.cancel()
                    win()
                } else {
                    rndImageChange()
                    iv.setImageResource(ivChange)
                }
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    iv3.setImageResource(R.drawable.image000)
                    iv3.setEnabled(true)
                }, 1500)

                healthPoint--
                health.text = "$healthPoint"
                if (healthPoint == 0) {
                    timer.cancel()
                    lose()
                }
            }
        }

        iv4.setOnClickListener {
            iv4.setImageResource(ivChange4)
            iv4.setEnabled(false)

            if (ivChange4 == ivChange) {
                if (listGame.isEmpty()) {
                    timer.cancel()
                    win()
                } else {
                    rndImageChange()
                    iv.setImageResource(ivChange)
                }
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    iv4.setImageResource(R.drawable.image000)
                    iv4.setEnabled(true)
                }, 1500)

                healthPoint--
                health.text = "$healthPoint"
                if (healthPoint == 0) {
                    timer.cancel()
                    lose()
                }
            }
        }

        iv5.setOnClickListener {
            iv5.setImageResource(ivChange5)
            iv5.setEnabled(false)

            if (ivChange5 == ivChange) {
                if (listGame.isEmpty()) {
                    timer.cancel()
                    win()
                } else {
                    rndImageChange()
                    iv.setImageResource(ivChange)
                }
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    iv5.setImageResource(R.drawable.image000)
                    iv5.setEnabled(true)
                }, 1500)

                healthPoint--
                health.text = "$healthPoint"
                if (healthPoint == 0) {
                    timer.cancel()
                    lose()
                }
            }
        }

        iv6.setOnClickListener {
            iv6.setImageResource(ivChange6)
            iv6.setEnabled(false)

            if (ivChange6 == ivChange) {
                if (listGame.isEmpty()) {
                    timer.cancel()
                    win()
                } else {
                    rndImageChange()
                    iv.setImageResource(ivChange)
                }
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    iv6.setImageResource(R.drawable.image000)
                    iv6.setEnabled(true)
                }, 1500)

                healthPoint--
                health.text = "$healthPoint"
                if (healthPoint == 0) {
                    timer.cancel()
                    lose()
                }
            }
        }

        iv7.setOnClickListener {
            iv7.setImageResource(ivChange5)
            iv7.setEnabled(false)

            if (ivChange7 == ivChange) {
                if (listGame.isEmpty()) {
                    timer.cancel()
                    win()
                } else {
                    rndImageChange()
                    iv.setImageResource(ivChange)
                }
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    iv7.setImageResource(R.drawable.image000)
                    iv7.setEnabled(true)
                }, 1500)

                healthPoint--
                health.text = "$healthPoint"
                if (healthPoint == 0) {
                    timer.cancel()
                    lose()
                }
            }
        }

        iv8.setOnClickListener {
            iv8.setImageResource(ivChange5)
            iv8.setEnabled(false)

            if (ivChange8 == ivChange) {
                if (listGame.isEmpty()) {
                    timer.cancel()
                    win()
                } else {
                    rndImageChange()
                    iv.setImageResource(ivChange)
                }
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    iv8.setImageResource(R.drawable.image000)
                    iv8.setEnabled(true)
                }, 1500)

                healthPoint--
                health.text = "$healthPoint"
                if (healthPoint == 0) {
                    timer.cancel()
                    lose()
                }
            }
        }
    }

    private fun getImage() {
        val listShuffle = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val newList = listShuffle.shuffled()

        ivChange1 = ImageChange().takeImage(newList[0])
        ivChange2 = ImageChange().takeImage(newList[1])
        ivChange3 = ImageChange().takeImage(newList[2])
        ivChange4 = ImageChange().takeImage(newList[3])
        ivChange5 = ImageChange().takeImage(newList[4])
        ivChange6 = ImageChange().takeImage(newList[5])
        ivChange7 = ImageChange().takeImage(newList[6])
        ivChange8 = ImageChange().takeImage(newList[7])

        listGame.add(ivChange1)
        listGame.add(ivChange2)
        listGame.add(ivChange3)
        listGame.add(ivChange4)
        listGame.add(ivChange5)
        listGame.add(ivChange6)
        listGame.add(ivChange7)
        listGame.add(ivChange8)
    }

    private fun rndImageChange() {
        val rndNum: Int = (0..<listGame.size).random()

        ivChange = listGame[rndNum]
        listGame.removeAt(rndNum)
    }

    private fun win() {
        scoreFinish = score + healthPoint + (timeResult / 1000)

        val dialogWin = Dialog(this)
        dialogWin.setContentView(R.layout.dialog_win)
        dialogWin.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        dialogWin.setCancelable(true)

        val textScore = dialogWin.findViewById<TextView>(R.id.dialogTextScore)

        ("${getText(R.string.score)} $scoreFinish").toString().also { textScore.text = it }

        dialogWin.findViewById<MaterialButton>(R.id.dialog_button_exit)
            .setOnClickListener {
                exitGame()
            }
        dialogWin.findViewById<MaterialButton>(R.id.dialog_button_restart)
            .setOnClickListener {
                restart()
            }
        dialogWin.findViewById<MaterialButton>(R.id.dialog_button_next)
            .setOnClickListener {
                nextLvl()
            }

        dialogWin.create()
        dialogWin.show()
    }

    private fun lose() {
        scoreFinish = score + healthPoint + (timeResult / 1000)

        val dialogLose = Dialog(this)
        dialogLose.setContentView(R.layout.dialog_lose)
        dialogLose.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        dialogLose.setCancelable(true)

        val textScore = dialogLose.findViewById<TextView>(R.id.dialogTextScoreLose)

        ("${getText(R.string.score)} $scoreFinish").toString().also { textScore.text = it }

        dialogLose.findViewById<MaterialButton>(R.id.dialog_button_lose_exit)
            .setOnClickListener {
                exitGame()
            }
        dialogLose.findViewById<MaterialButton>(R.id.dialog_button_lose_new_game)
            .setOnClickListener {
                startActivity(Intent(this@Level8, MainActivity::class.java))
                finish()
            }

        dialogLose.create()
        dialogLose.show()
    }

    private fun restart() {
        startActivity(
            Intent(this@Level8, this@Level8::class.java)
                .putExtra(Constant.HEALTH_GIVE, healthStart)
                .putExtra(Constant.SCORE_GIVE, score)
        )
        finish()
    }

    private fun exitGame() {
        Toast.makeText(
            this,
            R.string.goodbye,
            Toast.LENGTH_LONG
        )
            .show()
        finish()
    }

    private fun nextLvl() {
        if (timeDelay > 2000) {
            timeDelay -= 1000
            startActivity(
                Intent(this@Level8, this@Level8::class.java)
                    .apply {
                        putExtra(Constant.HEALTH_GIVE, healthPoint)
                        putExtra(Constant.SCORE_GIVE, scoreFinish)
                        putExtra(Constant.TIME_DELAY_GIVE, timeDelay)
                    }
            )
        } else {
            timeDelay = 3000

            startActivity(
                Intent(this@Level8, FinishGame::class.java)
                    .apply {
                        putExtra(Constant.HEALTH_GIVE, healthPoint)
                        putExtra(Constant.SCORE_GIVE, scoreFinish)
                        putExtra(Constant.TIME_DELAY_GIVE, timeDelay)
                    }
            )
        }
        finish()
    }
}