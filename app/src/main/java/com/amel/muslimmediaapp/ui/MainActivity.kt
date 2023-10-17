package com.amel.muslimmediaapp.ui

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.amel.muslimmediaapp.R
import com.amel.muslimmediaapp.adapter.SectionPagerAdapter
import com.amel.muslimmediaapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
    }

    private fun setUpViewPager() {
        binding.vpNews.adapter = SectionPagerAdapter(this)

        val tabList = arrayOf(
            "Common",
            "About Al Quran",
            "Al Jazeera",
            "Warn For Muslim"
        )
        TabLayoutMediator(binding.tabs, binding.vpNews) {
            tab, position -> tab.text = tabList[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        // For getting the SearchView and get the searchable config
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.option_search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    // To do release of the source, and to avoid memory leaks,
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}