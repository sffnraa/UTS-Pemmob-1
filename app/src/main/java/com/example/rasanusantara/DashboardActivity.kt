package com.example.rasanusantara

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rasanusantara.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = findViewById<ListView>(R.id.listView)

        val nameList = arrayOf("Rendang", "Pempek", "Gudeg", "Rawon", "Papeda", "Soto Banjar", "Ayam Betutu", "Serabi")
        val provList = arrayOf("Sumatra Barat", "Sumatra Selatan", "DI Yogyakarta", "Jawa Timur", "Papua", "Kalimantan Selatan", "Bali", "Jawa Barat")
        val imageList = intArrayOf(
            R.drawable.rendang,
            R.drawable.pempek,
            R.drawable.gudeg,
            R.drawable.rawon,
            R.drawable.papeda,
            R.drawable.sotobanjar,
            R.drawable.ayambetutu,
            R.drawable.serabi
        )

        val dataList = nameList.indices.map {
            ListData(imageList[it], nameList[it], provList[it])
        }


        val adapter = ListAdapter(this, dataList)
        listView.adapter = adapter

    }
}