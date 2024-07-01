package com.clone.dynamicform.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.clone.dynamicform.ui.TabFragment

class ViewPagerAdapter(
    private val tabAList: List<String>,
    private val tabFragment: List<Fragment>,
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = tabAList.size

    override fun createFragment(position: Int): Fragment {
        return if (position < tabFragment.size) {
            tabFragment[position]
        } else {
            TabFragment("")
        }
    }
}