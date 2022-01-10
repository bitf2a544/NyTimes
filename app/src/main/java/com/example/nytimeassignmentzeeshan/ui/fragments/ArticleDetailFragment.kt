package com.example.nytimeassignmentzeeshan.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nytimeassignmentzeeshan.R

import com.example.nytimeassignmentzeeshan.viewModel.ArticleDetailViewModel
import com.example.nytimeassignmentzeeshan.databinding.FragmentArticleDetailBinding
import com.example.nytimeassignmentzeeshan.model.Article
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class ArticleDetailFragment @Inject constructor() :
    Fragment(R.layout.fragment_article_detail) {

    private var binding: FragmentArticleDetailBinding? = null
    lateinit var viewModel: ArticleDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ArticleDetailViewModel::class.java)
        if (arguments?.getSerializable(MostPopularArticleListFragment.KEY_ARTICLE) != null) {
            viewModel.setArticle(arguments?.getSerializable(MostPopularArticleListFragment.KEY_ARTICLE) as Article)
        }
        val binding = FragmentArticleDetailBinding.bind(view)
        this.binding = binding.also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }
        updateActionBarTitle()
    }


    private fun updateActionBarTitle(){
        (requireActivity() as AppCompatActivity?)?.supportActionBar?.title = "Article Detail"
    }
}