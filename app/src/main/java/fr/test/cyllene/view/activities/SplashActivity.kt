package fr.test.cyllene.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import fr.test.cyllene.R
import fr.test.cyllene.utils.Constants
import fr.test.cyllene.utils.SharedPreferences
import fr.test.cyllene.view.Application
import javax.inject.Inject

class SplashActivity : Activity() {

    @Inject
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        (application as Application).sharedPreferencesComponent?.inject(this)

        Handler().postDelayed({
            if(sharedPreferences.getLoginStatus(Constants.LOGIN)) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
            else{
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_TIME_OUT = 1000
    }
}