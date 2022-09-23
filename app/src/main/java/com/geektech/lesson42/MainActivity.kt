package com.geektech.lesson42

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.geektech.lesson42.data.Preference
import com.geektech.lesson42.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navDestination= arrayListOf(
            R.id.navigation_home,
            R.id.navigation_dashboard,
            R.id.navigation_notifications,
            R.id.navigation_profile

        )

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        if (!Preference(this).getIsShowBoarding()) {
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            navController.navigate(R.id.onBoardingFragment)
        }
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.taskFragment,
                R.id.navigation_profile


            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{ controller,destination,arguments->
            navView.isVisible=navDestination.contains(destination.id)
            if (destination.id==R.id.onBoardingFragment) {
                supportActionBar?.hide()
            }else{
                supportActionBar?.show()
            }
        }
    }
}