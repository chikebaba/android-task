package com.example.android_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.android_task.databinding.ActivityMainBinding
import com.example.android_task.ui.gallery.GalleryFragment
import com.example.android_task.ui.home.HomeFragment
import com.example.android_task.ui.slideshow.SlideshowFragment
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPager : Fragment() {

    private lateinit var demoCollectionPagerAdapter: DemoCollectionPagerAdapter
    private lateinit var viewPager: ViewPager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionPagerAdapter = DemoCollectionPagerAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.pager)
        val adapter = DemoCollectionPagerAdapter(childFragmentManager)
        adapter.addFragment(HomeFragment(), "Task 1")
        adapter.addFragment(GalleryFragment(), "Task 2")
        adapter.addFragment(SlideshowFragment(), "Task 3")
        viewPager.adapter = adapter
        viewPager.tab_layout.setupWithViewPager(viewPager.pager)
    }
}

class DemoCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int) = mFrgmentList[position]
    override fun getPageTitle(position: Int) = mFrgmentTitleList[position]
    private val mFrgmentList = ArrayList<Fragment>()
    private val mFrgmentTitleList = ArrayList<String>()
    override fun getCount() = mFrgmentList.size
    fun addFragment(fragment: Fragment, title: String) {
        mFrgmentList.add(fragment)
        mFrgmentTitleList.add(title)
    }
}
