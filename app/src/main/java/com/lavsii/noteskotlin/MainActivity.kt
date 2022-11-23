package com.lavsii.noteskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.lavsii.noteskotlin.databinding.ActivityMainBinding
import com.lavsii.noteskotlin.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var navController: NavController

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP_ACTIVITY = this
        mToolbar = binding.toolbar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)
        title = getString(R.string.app_name)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}