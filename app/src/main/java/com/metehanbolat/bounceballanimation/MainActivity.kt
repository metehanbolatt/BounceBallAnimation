package com.metehanbolat.bounceballanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import com.metehanbolat.bounceballanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val displayHeight: Int get() = this.resources.displayMetrics.heightPixels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            bounceButton.setOnClickListener {
                ballImage.clearAnimation()
                val transAnim = TranslateAnimation(
                    0f, 0f, 0f, (displayHeight / 2).toFloat()
                ).apply {
                    startOffset = 500
                    duration = 2500
                    fillAfter = true
                    interpolator = BounceInterpolator()
                }
                ballImage.startAnimation(transAnim)
            }
        }
    }
}