package com.example.myapplication_task.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.myapplication_task.R
import com.example.myapplication_task.model.MainModel


class ScreenSlidePagerAdapter(val sections: List<MainModel>) : PagerAdapter() {

    override fun getCount(): Int {
        return sections.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }
    override fun instantiateItem(parent : ViewGroup, position: Int): Any {
        val view =  LayoutInflater
            .from(parent.context)
            .inflate(R.layout.adapter_item, parent, false)
        view.findViewById<ImageView>(R.id.image).setImageResource(sections[position].image)
        (parent as ViewPager).addView(view, 0)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View?)
    }

}