package com.clone.dynamicform.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.clone.dynamicform.R
import com.clone.dynamicform.databinding.ActivityMainBinding
import com.clone.dynamicform.domain.UseCases
import com.clone.dynamicform.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val form = UseCases()[this]
        val tabTitleList = mutableListOf<String>()
        val tabFragmentList = mutableListOf<Fragment>()
        form?.let {
            it.pages.forEach { page ->
                tabTitleList.add(page.title)
                tabFragmentList.add(TabFragment(page.title))
            }
        }
        binding.apply {
            viewPager.offscreenPageLimit = tabTitleList.size
            viewPager.adapter = ViewPagerAdapter(tabTitleList, tabFragmentList, supportFragmentManager, lifecycle)
            TabLayoutMediator(tabLayout,viewPager) { tab, position ->
                tab.text = tabTitleList[position]
            }.attach()
        }
    }
}