package com.example.nytimeassignmentzeeshan.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.nytimeassignmentzeeshan.ui.adapter.ArticleAdapter
import com.example.nytimeassignmentzeeshan.viewModel.ArticlesViewModel
import javax.inject.Inject

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.nytimeassignmentzeeshan.R
import com.example.nytimeassignmentzeeshan.databinding.FragmentMostPopularArticleListBinding
import com.example.nytimeassignmentzeeshan.utils.NetworkUtil
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

import androidx.core.content.ContextCompat


@AndroidEntryPoint
class MostPopularArticleListFragment @Inject constructor(private val articleAdapter: ArticleAdapter) :
    Fragment(R.layout.fragment_most_popular_article_list) {

    private var mBinding: FragmentMostPopularArticleListBinding? = null
    private val mViewModel: ArticlesViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMostPopularArticleListBinding.bind(view)
        updateActionBarTitle()
        this.mBinding = binding.also {
            it.lifecycleOwner = this
            it.viewModel = mViewModel
            it.rvArticles.adapter = articleAdapter
        }
        addItemClickListener()
        fetchArticles()
    }

    private fun fetchArticles() {
        if (NetworkUtil.isNetworkAvailable(requireContext())) {
            mBinding?.rvArticles?.visibility = View.VISIBLE
            mViewModel.isInternetAvailable.value = true
            mViewModel.fetchArticlesFromNetwork()
            return
        } else{
            mViewModel.isInternetAvailable.value = false
            mBinding?.errorTV?.text = resources.getString(R.string.network_error)
            mBinding?.rvArticles?.visibility = View.GONE
            Snackbar.make(mBinding!!.root, R.string.network_error, Snackbar.LENGTH_LONG)
                .setAction("Ok") {}
                .show()
        }

    }

    private fun addItemClickListener() {

        articleAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable(KEY_ARTICLE, it)
            val action = MostPopularArticleListFragmentDirections.actionArticleListFragmentToArticleDetailFragment()
            findNavController().navigate(
                action.actionId, bundle
            )
        }

        mBinding?.swipeRefreshLayout?.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.color2),
            ContextCompat.getColor(requireContext(), R.color.color3))
        mBinding?.swipeRefreshLayout?.setOnRefreshListener {
            mBinding?.swipeRefreshLayout?.isRefreshing = false
            fetchArticles();
        }
    }

    private fun updateActionBarTitle() {
        (requireActivity() as AppCompatActivity?)?.supportActionBar?.title = "Most Popular Articles "
    }

    companion object {
        const val KEY_ARTICLE = "article"
    }


}


