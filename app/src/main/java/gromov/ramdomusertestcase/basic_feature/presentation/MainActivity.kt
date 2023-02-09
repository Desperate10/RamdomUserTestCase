package gromov.ramdomusertestcase.basic_feature.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import gromov.ramdomusertestcase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            val navController = usersNavHostFragment.getFragment<NavHostFragment>().navController
            bottomNavigationView.setupWithNavController(navController)
        }
    }
}