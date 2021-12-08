package com.cubidevs.dccomics.tabbed

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cubidevs.dccomics.R
import com.cubidevs.dccomics.preference.SettingsFragment

private val TAB_TITLES = arrayOf(
    R.string.title_list,
    R.string.title_preference
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position){
            0 -> return TabContainerFragment()
            else -> return SettingsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}