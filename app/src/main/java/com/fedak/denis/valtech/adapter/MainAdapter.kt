package com.fedak.denis.valtech.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fedak.denis.valtech.R
import com.fedak.denis.valtech.callback.MainCallback
import com.fedak.denis.valtech.model.NotesModel
import kotlinx.android.synthetic.main.main_list_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var notes: ArrayList<NotesModel> = arrayListOf()

    var mainCallback: MainCallback? = null

    fun setData(notes: ArrayList<NotesModel>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.main_list_item, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) = holder.bind(notes[position])

    inner class MainViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: NotesModel) {
            itemView.nameView.text = item.userName
            itemView.linkView.text = item.link

            itemView.setOnClickListener {
                mainCallback?.let {
                    mainCallback!!.onMainItemClick(adapterPosition)
                }

            }
        }
    }

}