package pl.putala.speedwayo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
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
        name.text = Constant.rankingUser[i]

        val seek = holder.view.findViewById<SeekBar>(R.id.seekBarAlfa)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                points.text = seek.progress.toString()
            }
            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
                points.text = seek.progress.toString()
            }
            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                points.text = seek.progress.toString()
            }
        })


//        points.text = Constant.rankingPoints[i]
        if (i<9) {
            position.text = "0" + (i+1)
        } else {
            position.text = "" + (i+1)
        }
    }

    override fun getItemCount(): Int {
        return Constant.rankingUser.size
    }
}


class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)
