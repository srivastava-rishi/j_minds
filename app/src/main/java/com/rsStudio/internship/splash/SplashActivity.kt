package com.rsStudio.internship.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.rsStudio.internship.R
import com.rsStudio.internship.base.BaseActivity
import com.rsStudio.internship.databinding.ActivitySplashBinding
import com.rsStudio.internship.main.MainActivity

class SplashActivity : BaseActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        initTheme()
        gotoMainActivity()

    }

    private fun initTheme(){
        window.statusBarColor = resources.getColor(R.color.lightBlack)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }

    private fun gotoMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 500
        )
    }



}