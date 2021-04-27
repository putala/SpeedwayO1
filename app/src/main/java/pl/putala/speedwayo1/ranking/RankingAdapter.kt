package pl.putala.speedwayo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.putala.speedwayo1.Constant.rankingUser


class RankingAdapter: RecyclerView.Adapter<RankingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_ranking, parent, false)
        return RankingViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RankingViewHolder, i: Int) {
        val name = holder.view.findViewById<TextView>(R.id.textViewUserNickname)
        val points = holder.view.findViewById<TextView>(R.id.textViewPoints)
        val position = holder.view.findViewById<TextView>(R.id.textViewPosition)
        name.text = rankingUser[i]
        points.text = Constant.rankingPoints[i]
        if (i<9) {
            position.text = "0" + (i+1)
        } else {
            position.text = "" + (i+1)
        }
    }

    override fun getItemCount() = rankingUser.size

}


class RankingViewHolder(val view: View): RecyclerView.ViewHolder(view)
