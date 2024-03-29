package com.example.nytimeassignmentzeeshan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimeassignmentzeeshan.viewModel.ArticleItemViewModel
import com.example.nytimeassignmentzeeshan.databinding.RowArticleItemBinding
import com.example.nytimeassignmentzeeshan.model.Article
import javax.inject.Inject
class ArticleAdapter @Inject constructor() :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private lateinit var onItemClickListener: ((Article) -> Unit)
    var articles: List<Article> get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val rowArticleBinding: RowArticleItemBinding =
            RowArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(rowArticleBinding)
    }


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.onBind(position)

    }


    override fun getItemCount(): Int {
        return articles.size
    }

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

    }
    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    inner class ArticleViewHolder(private val binding: RowArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            binding.articleItemViewModel = ArticleItemViewModel(articles[position])
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                if (this@ArticleAdapter::onItemClickListener.isInitialized)
                    onItemClickListener.invoke(articles[position])
            }
        }
    }
}