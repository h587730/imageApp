package com.example.imageapp.helper

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imageapp.Model.Person
import com.example.imageapp.R

private const val TAG1 = "onCreateViewHolder"
private const val TAG2 = "onBindViewHolder"

class PersonAdapter(val context: Context, val persons: List<Person>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false)
        Log.i(TAG1, "View created")
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        val person = persons[position]
        Log.i(TAG2, "Binds data to view")
        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val ivPic: ImageView = itemView.findViewById(R.id.ivPic)

        fun bind(person: Person) {
            tvName.text = person.name
            ivPic.setImageBitmap(person.image)

        }
    }
}