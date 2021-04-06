package com.example.myapplicationtest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutine.data.model.Post
import com.example.myapplicationtest.R
import com.example.myapplicationtest.databinding.RowsBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder> {
    var posts: ArrayList<Post>

    constructor(posts: ArrayList<Post>) {
        this
            .posts = posts
    }


    public class MainHolder(rowsBinding: RowsBinding) : RecyclerView.ViewHolder(rowsBinding.root) {
        var rowsBinding: RowsBinding

        init {
            this.rowsBinding = rowsBinding
        }

        fun bind(post: Post) {
            rowsBinding.obj = post
            rowsBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        var rowsBinding: RowsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.rows,
            parent,
            false
        )

        return MainHolder(rowsBinding)
    }

    fun notifyList(psotsList: ArrayList<Post>) {
        this.posts = psotsList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        if (posts == null)
            return 0
        else
            return posts.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(posts.get(position))
    }
}