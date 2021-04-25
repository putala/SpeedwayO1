package pl.putala.speedwayo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RankingAdapter: RecyclerView.Adapter<RankingAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false)
//        return ContestAdapter.ExampleViewHolder(itemView)

        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_ranking, parent, false)
        return RankingAdapter.MyViewHolder(layoutInflater)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 30
    }


    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)

}


