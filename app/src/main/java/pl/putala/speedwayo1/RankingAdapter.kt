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

    override fun onBindViewHolder(holder: MyViewHolder, i: Int) {
        val name = holder.view.findViewById<TextView>(R.id.textViewUserNickname)
        val points = holder.view.findViewById<TextView>(R.id.textViewPoints)
        val position = holder.view.findViewById<TextView>(R.id.textViewPosition)
        name.setText(RankingDatabase.rankingUser[i])
        points.setText(RankingDatabase.rankingPoints[i])
        if (i<9) {
            position.setText("0" + (i+1))
        } else {
            position.setText("" + (i+1))
        }
    }

    override fun getItemCount(): Int {
        return RankingDatabase.rankingUser.size
    }
}


class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)
