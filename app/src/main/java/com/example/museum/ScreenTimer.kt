package com.example.museum

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.museum.databinding.ActivityScreenBinding

private val splashTimeOut: Long = 5000 // 3 seconds

class ScreenTimer : AppCompatActivity() {
    lateinit var binding: ActivityScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countDownTimer = object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                binding.tvTimer.setText(getString(R.string.timer,seconds.toString()))
            }

            override fun onFinish() {
                launchMainActivity()
            }
        }

        countDownTimer.start()
    }

    fun launchMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
