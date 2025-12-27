package com.example.myvuserver

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myvuserver.databinding.ItemLogBinding

class LogAdapter : RecyclerView.Adapter<LogAdapter.LogViewHolder>() {
    private val data = mutableListOf<String>()

    fun submit(list: List<String>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
        val binding = ItemLogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class LogViewHolder(binding: ItemLogBinding) : RecyclerView.ViewHolder(binding.root) {
        private val text: TextView = binding.logText
        fun bind(line: String) {
            text.text = line
        }
    }
}
