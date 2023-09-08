package com.example.submissionandroidpemula

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DescriptionPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_page)

        supportActionBar?.title = "Detail"
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val somethinc = intent.getParcelableExtra<Somethinc>(EXTRA_SOMETHINC) as Somethinc


        val ivPhoto: ImageView = findViewById(R.id.iv_detailPhoto)
        val tvDescription: TextView = findViewById(R.id.tv_detailDescription)
        val tvName: TextView = findViewById(R.id.tv_detailName)
        val tvDetail: TextView =findViewById(R.id.tv_detailDetail)

        Glide.with(this)
            .load(somethinc.photo)
            .into(ivPhoto)

        tvName.text = somethinc.name
        tvDescription.text = somethinc.description
        tvDetail.text = somethinc.detail

    }

    companion object{
        const val EXTRA_SOMETHINC = "extra_somethinc"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_share ->{
                val myIntent = Intent(Intent.ACTION_SEND)
                startActivity(Intent.createChooser(myIntent, "Share Using"))
                Toast.makeText(this, "Bagikan", Toast.LENGTH_SHORT).show()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}