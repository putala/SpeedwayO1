package pl.putala.speedwayo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RankingAdapter: RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_ranking, parent, false)
        return MyViewHolder(layoutInflater)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name = holder.view.findViewById<TextView>(R.id.textViewUserNickname)
        val points = holder.view.findViewById<TextView>(R.id.textViewPoints)
        name.setText(RankingDatabase.rankingUser[position])
        points.setText(RankingDatabase.rankingPoints[position])
//        name.setText("idytidtyi")
//        points.setText("654")

    }


    override fun getItemCount(): Int {
        return RankingDatabase.rankingUser.size
    }

}


class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)
