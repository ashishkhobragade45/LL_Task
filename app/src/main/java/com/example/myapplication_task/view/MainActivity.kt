package com.example.myapplication_task.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.myapplication_task.R
import com.example.myapplication_task.adapters.ListItemAdapter
import com.example.myapplication_task.adapters.ScreenSlidePagerAdapter
import com.example.myapplication_task.databinding.ActivityMainBinding
import com.example.myapplication_task.model.ListModel
import com.example.myapplication_task.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mainViewModel = MainViewModel(application)
        binding.header.viewPager.adapter = ScreenSlidePagerAdapter(mainViewModel.sections)
        binding.header.viewPager.setPageMargin(30)
        binding.header.tabLayout.setupWithViewPager(binding.header.viewPager)
        binding.list.apply {
            adapter = ListItemAdapter(mainViewModel.sections[0].list)
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        binding.header.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                val listItemAdapter : ListItemAdapter = findViewById<RecyclerView>(R.id.list).adapter as ListItemAdapter
                listItemAdapter.notifyDataSetChanged(mainViewModel.sections[position].list)
                val searchQuery = binding.layoutSearchBar.editTextSearch.text
                binding.layoutSearchBar.editTextSearch.clearComposingText()
                binding.layoutSearchBar.editTextSearch.text = searchQuery
                binding.layoutSearchBar.editTextSearch.setSelection(binding.layoutSearchBar.editTextSearch.length())
            }
        })
        binding.layoutSearchBar.editTextSearch.addTextChangedListener {
            val searchString = it.toString().trim();
            val screenSlidePagerAdapter : ScreenSlidePagerAdapter = binding.header.viewPager.adapter as ScreenSlidePagerAdapter
            val list = screenSlidePagerAdapter.sections.get(binding.header.viewPager.currentItem).list
            mainViewModel.searchItems(searchString,list)
                .observe(this@MainActivity, Observer<ArrayList<ListModel>> {
                    val listItemAdapter: ListItemAdapter = findViewById<RecyclerView>(R.id.list).adapter as ListItemAdapter
                    listItemAdapter.notifyDataSetChanged(it)
                })
        }
    }
}