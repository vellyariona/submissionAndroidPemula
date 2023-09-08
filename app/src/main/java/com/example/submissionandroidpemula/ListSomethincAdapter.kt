package com.example.submissionandroidpemula

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionandroidpemula.DescriptionPageActivity.Companion.EXTRA_SOMETHINC

class ListSomethincAdapter(private val listSomethinc: ArrayList<Somethinc>) : RecyclerView.Adapter<ListSomethincAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_somethinc, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val somethinc = listSomethinc[position]
        val (name, description, photo) = listSomethinc[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listSomethinc[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        holder.btnDetail.setOnClickListener { v ->
            val intent = Intent(v.context, DescriptionPageActivity::class.java)
            intent.putExtra(EXTRA_SOMETHINC, somethinc)
            v.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int = listSomethinc.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val btnDetail: ImageButton = itemView.findViewById(R.id.about_page)
    }
}
