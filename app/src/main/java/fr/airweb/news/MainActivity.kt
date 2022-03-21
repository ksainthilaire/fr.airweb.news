package fr.airweb.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import fr.airweb.news.presentation.fragment.NewsListFragmentDirections
import fr.airweb.news.presentation.fragment.SettingsFragmentDirections

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val nav = findViewById<BottomNavigationView>(R.id.bottomNavigationNew)
        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.newsListFragment)
                }

                R.id.about -> {
                    navController.navigate(R.id.settingsFragment)
                }

            }
            true
        }
    }
}

