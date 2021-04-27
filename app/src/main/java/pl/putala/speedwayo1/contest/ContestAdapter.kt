package pl.putala.speedwayo1.contest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.putala.speedwayo1.Constant.match
import pl.putala.speedwayo1.Constant.result
import pl.putala.speedwayo1.Constant.teams
import pl.putala.speedwayo1.Constant.teamsImage
import pl.putala.speedwayo1.R


class ContestAdapter: RecyclerView.Adapter<ContestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false)
        return  ContestViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContestViewHolder, i: Int) {

        val imageViewFirstTeam = holder.view.findViewById<ImageView>(R.id.imageViewFirstTeam)
        val imageViewSecondTeam = holder.view.findViewById<ImageView>(R.id.imageViewSecondTeam)
        val textViewFirstTeam = holder.view.findViewById<TextView>(R.id.textViewFirstTeam)
        val textViewResult = holder.view.findViewById<TextView>(R.id.textViewResult)
        val textViewSecondTeam = holder.view.findViewById<TextView>(R.id.textViewSecondTeam)
        val textViewTypeResult = holder.view.findViewById<TextView>(R.id.textViewTypeResult)
        val textViewDate = holder.view.findViewById<TextView>(R.id.textViewDate)

        imageViewFirstTeam.setImageResource(teamsImage[match[i].substring(0, 2).toInt()])
        imageViewSecondTeam.setImageResource(teamsImage[match[i].substring(2, 4).toInt()])
        textViewFirstTeam.text = ("" + teams[match[i].substring(0, 2).toInt()])
        textViewResult.text = (result[i].substring(0, 2) + " : " + result[i].substring(2, 4))
        textViewSecondTeam.text = ("" + teams[match[i].substring(2, 4).toInt()])

        val seek = holder.view.findViewById<SeekBar>(R.id.seekBarTyping)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                textViewTypeResult.text = seek.progress.toString()
            }
            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
                textViewTypeResult.text = seek.progress.toString()
            }
            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                textViewTypeResult.text = seek.progress.toString()
            }
        })

    }


    override fun getItemCount() = match.size

}


class ContestViewHolder(val view: View): RecyclerView.ViewHolder(view)
