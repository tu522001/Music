package com.example.music


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.adapter.CustomAdapter
import com.example.music.data.Music
import com.example.music.databinding.ActivityMusicBinding
import com.example.music.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivityMusic : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMusicBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val customAdapter: CustomAdapter by lazy { CustomAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

                val music = Music(1, "CCC", "30s")
                mainViewModel.insertData(music)


        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = customAdapter

        mainViewModel.readData.observe(this, {
            customAdapter.setData(it)
        })
        Toast.makeText(this,"$binding",Toast.LENGTH_SHORT).show()

// code sửa lần 1
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // ArrayList of class ItemsViewModel
//        val dataInOrder = ArrayList<ItemsViewModel>()
//        val arraySong = ArrayList<ItemsViewModel>()
//
//
//        // This loop will create 20 Views containing
//        // the image with the count of view
//        for (i in 1..20) {
//            dataInOrder.add(ItemsViewModel(R.drawable.icon_more_vert, ""+i+""))
//        }
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(dataInOrder)
//
//        // Setting the Adapter with the recyclerview
//        recyclerView.adapter = adapter


    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//
//        val search = menu?.findItem(R.id.menu_search)
//        val searchView = search?.actionView as? SearchView
//        searchView?.isSubmitButtonEnabled = true
//        searchView?.setOnQueryTextListener(this)
//
//        return true
//    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//
//        val search = menu?.findItem(R.id.menu_search)
//        val searchView = search?.actionView as? SearchView
//        searchView?.isSubmitButtonEnabled = true
//        searchView?.setOnQueryTextListener(this)
//        return super.onCreateOptionsMenu(menu)
//    }
//
    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"

        mainViewModel.searchDatabase(searchQuery).observe(this, { list ->
            list.let {
                customAdapter.setData(it)
            }
        })
    }

}
