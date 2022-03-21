package fr.airweb.news.presentation.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.airweb.news.R
import fr.airweb.news.domain.model.NewsPreview
import fr.airweb.news.presentation.fragment.NewsListFragmentDirections

class NewsListAdapter(
    private var dataSet: List<NewsPreview>,
    private val fragment: Fragment
) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val container: CardView = view.findViewById(R.id.container)
        val title: TextView = view.findViewById(R.id.title)
        val date: TextView = view.findViewById(R.id.date)
        private val picture: ImageView = view.findViewById(R.id.picture)


        fun loadPicture(url: String) = Glide.with(view.context)
            .load(url)
            .centerCrop()
            .into(picture)




    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.news_row_item, viewGroup, false)

        view.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("newsId", 5)


            val action = NewsListFragmentDirections.actionNewsListFragmentToArticleFragment()
            fragment.findNavController().navigate(action)
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val news = dataSet[position]


        with(viewHolder) {
            title.text = news.title
            date.text = news.dateformated
            news.picture?.let { loadPicture(it) }
        }


    }

    fun updateData(newDataSet: List<NewsPreview>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }

    override fun getItemCount() = dataSet.size
}