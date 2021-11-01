package com.example.swipeview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.view_item.view.*

class SwipeVIewAdapter(
    private val context: Context,
    private var myArrayList: ArrayList<ModelCardViewItem>
) : PagerAdapter() {

    private lateinit var swipeImage: ImageView
    private lateinit var movieTitle: TextView
    private lateinit var movieDate: TextView

    override fun getCount(): Int {
        return myArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    //inflate the layout swipe view item
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item, container, false)

        //get the files
        val model = myArrayList[position]
        val title = model.title
        val date = model.date
        val image = model.image

        //set the items to the UI
        view.movieImage.setImageResource(image)
        view.movie_title.text = title
        view.movie_date.text = date

        //handle click listeners
        view.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"something", Toast.LENGTH_LONG).show()
        })
        //adding view to the container
        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
       // super.destroyItem(container, position, `object`)
    }



}