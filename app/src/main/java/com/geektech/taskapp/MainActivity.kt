package com.geektech.taskapp

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.geektech.taskapp.databinding.ActivityMainBinding
import com.geektech.taskapp.data.Pref
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.navigation_profile,
                R.id.taskFragment,
                R.id.authFragment,
                R.id.acceptFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val bottomNavFragments = arrayListOf(
            R.id.navigation_home,
            R.id.navigation_dashboard,
            R.id.navigation_notifications,
            R.id.navigation_profile)
        navController.addOnDestinationChangedListener{ controller, destination, arguments ->
            navView.isVisible = bottomNavFragments.contains(destination.id)
            if (destination.id==R.id.onBoardingFragment || destination.id==R.id.splashFragment){
                supportActionBar?.hide()
            }else supportActionBar?.show()
            }


    }
}