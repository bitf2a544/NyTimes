package com.example.nytimeassignmentzeeshan.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.nytimeassignmentzeeshan.ui.adapter.ArticleAdapter
import com.example.nytimeassignmentzeeshan.ui.fragments.ArticleDetailFragment
import com.example.nytimeassignmentzeeshan.ui.fragments.MostPopularArticleListFragment
import javax.inject.Inject

class ArticleFragmentFactory @Inject constructor(
    private val imageRecyclerAdapter: ArticleAdapter
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            MostPopularArticleListFragment::class.java.name -> MostPopularArticleListFragment(imageRecyclerAdapter)
            ArticleDetailFragment::class.java.name -> ArticleDetailFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}