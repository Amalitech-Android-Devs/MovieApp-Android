package com.example.swipeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.R
import kotlinx.android.synthetic.main.activity_swip_view.*
import java.text.FieldPosition


class SwipeView : AppCompatActivity() {
    //rendering the actionbar
    private lateinit var actionBar: ActionBar

    //instantiate the modelArrayList and the pagerAdapter
    private lateinit var modelViewList: ArrayList<ModelCardViewItem>
    private lateinit var pagerAdapter: SwipeVIewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swip_view)

        //initializing the actionbar
        actionBar = this.supportActionBar!!//the double !! is a non-null assertion call
        supportActionBar?.hide()//hiding the actionbar

        loadPopularMovies()
        loadTvShows()
        loadContinueWatching()
        // adding page changer listener to the viewPagerPopularMovies
        viewPagerPopularMovies.addOnAdapterChangeListener(object :
            ViewPager.OnAdapterChangeListener {

            fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //change the title of the actionbar
                val title = modelViewList[position].title
                actionBar.title = title
            }

            override fun onAdapterChanged(
                viewPager: ViewPager,
                oldAdapter: PagerAdapter?,
                newAdapter: PagerAdapter?
            ) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun loadPopularMovies() {
        modelViewList = ArrayList()
        //adding movie posters
        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "GodZilla",
                "05/05/2021",
                R.drawable.rambo
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Besties",
                "12/05/2020",
                R.drawable.zombie
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "welcome home",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )
        //setting up popular movies adapter
        pagerAdapter = SwipeVIewAdapter(this, modelViewList)
        viewPagerPopularMovies.adapter =
            pagerAdapter // make sure you set the adapter to the viewpager id's in the xml file
        //viewPagerPopularMovies.setPadding(10,0,20,0)// setting default pager padding


    }

    private fun loadContinueWatching() {
        modelViewList = ArrayList()
        //adding movie posters
        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "GodZilla",
                "05/05/2021",
                R.drawable.rambo
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Besties",
                "12/05/2020",
                R.drawable.zombie
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "welcome home",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )
        //setting up popular movies adapter
        pagerAdapter = SwipeVIewAdapter(this, modelViewList)
        viewPagerTvShows.adapter =
            pagerAdapter // make sure you set the adapter to the viewpager id's in the xml file
        viewPagerPopularMovies.setPadding(10,0,20,0)// setting default pager padding


    }

    private fun loadTvShows() {
        modelViewList = ArrayList()
        //adding movie posters
        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "GodZilla",
                "05/05/2021",
                R.drawable.rambo
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Besties",
                "12/05/2020",
                R.drawable.zombie
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "welcome home",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )

        modelViewList.add(
            ModelCardViewItem(
                "Avengers",
                "12/05/2020",
                R.drawable.avenger
            )
        )
        //setting up popular movies adapter
        pagerAdapter = SwipeVIewAdapter(this, modelViewList)
        viewPagerContWatching.adapter =
            pagerAdapter // make sure you set the adapter to the viewpager id's in the xml file
        //viewPagerPopularMovies.setPadding(10,0,20,0)// setting default pager padding


    }
}