package com.example.submissionandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvSomethinc: RecyclerView
    private val list = ArrayList<Somethinc>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title="Somethinc Serum"

        rvSomethinc = findViewById(R.id.rv_somethinc)
        rvSomethinc.setHasFixedSize(true)
        list.addAll(getListSomethinc())
        showRecyclerList()
    }

    private fun getListSomethinc(): ArrayList<Somethinc> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
//        detail
        val dataDetail = resources.getStringArray(R.array.data_detail)
        val listSomethinc = ArrayList<Somethinc>()
        for (i in dataName.indices) {
            val somethinc = Somethinc(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataDetail[i])
            listSomethinc.add(somethinc)
        }
        return listSomethinc
    }

    private fun showRecyclerList() {
        rvSomethinc.layoutManager = LinearLayoutManager(this)
        val listSomethincAdapter = ListSomethincAdapter(list)
        rvSomethinc.adapter = listSomethincAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutPageActivity::class.java)
                startActivity(moveIntent)

            }
        }
        return super.onOptionsItemSelected(item)
    }
}