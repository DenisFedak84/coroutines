package com.fedak.denis.valtech.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fedak.denis.mvvmcoroutine.base.BaseActivity
import com.fedak.denis.valtech.R
import com.fedak.denis.valtech.adapter.MainAdapter
import com.fedak.denis.valtech.callback.MainCallback
import com.fedak.denis.valtech.model.NotesModel
import com.fedak.denis.valtech.view_model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        initRecyclerView()
        loadData()
    }

    private fun initToolbar() {
        toolbar.title = getString(R.string.main_activity)
        setSupportActionBar(toolbar)
    }

    private fun initRecyclerView() {
        adapter = MainAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.mainCallback = object : MainCallback {
            override fun onMainItemClick(position: Int) {
               toast(position.toString())
            }
        }
    }

    private fun loadData() {
        mainViewModel = getViewModel(this, MainViewModel::class.java)
        mainViewModel.getNotes().observe(this, Observer { notes ->
            mainViewModel.finishLoading()
            adapter.setData(notes as ArrayList<NotesModel>)
        })
        mainViewModel.getLoading().observe(this, Observer { state -> progressBarView.visibility = state })
    }
}
