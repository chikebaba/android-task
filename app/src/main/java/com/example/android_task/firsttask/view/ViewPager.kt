package com.example.android_task.firsttask.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.android_task.R
import com.example.android_task.firsttask.view.ui.gallery.GalleryFragment
import com.example.android_task.firsttask.view.ui.home.HomeFragment
import com.example.android_task.firsttask.view.ui.slideshow.SlideshowFragment
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPager : Fragment() {

    private lateinit var demoCollectionPagerAdapter: DemoCollectionPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
     inflater: LayoutInflater,
     container: ViewGroup?,
     savedInstanceState: Bundle?
 ) =  inflater.inflate(R.layout.fragment_view_pager, container, false)

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


