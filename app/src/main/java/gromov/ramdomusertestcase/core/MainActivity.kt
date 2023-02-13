package gromov.ramdomusertestcase.core

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import gromov.ramdomusertestcase.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var keepSplashOnScreen = true
    private val delay = 2000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        Handler(Looper.getMainLooper()).postDelayed({ keepSplashOnScreen = false }, delay)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            val navController = usersNavHostFragment.getFragment<NavHostFragment>().navController
            bottomNavigationView.setupWithNavController(navController)
        }
    }
}