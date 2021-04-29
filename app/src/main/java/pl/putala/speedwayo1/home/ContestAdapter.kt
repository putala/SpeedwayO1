package pl.putala.speedwayo1.contest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.putala.speedwayo1.Constant.ConstTeams
import pl.putala.speedwayo1.Constant.CONTEST
import pl.putala.speedwayo1.Constant.ConstTeamsImage
import pl.putala.speedwayo1.Constant.RESULTS
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.data.Admin


class ContestAdapter : RecyclerView.Adapter<ContestAdapter.ContestViewHolder>() {

    private var meczc = "00000000000000000000000000000000"
    private val PROFILE_DEBUG = "PROFILE_DEBUG"


    fun setAdmin(admin: Admin?) {
        if (admin != null) {
            meczc = admin.teams.toString()
            Log.d(PROFILE_DEBUG, meczc)
            notifyDataSetChanged()
        }
    }



//
//    fun setAdmin(adminek: Admin) {
//        meczc = adminek.teams.toString()
//    }




//    private val adminList = ArrayList<Admin>()

//
//    fun setAdmin(adminek: Admin) {
//        meczc = adminek.teams.toString()
//
////
////        adminList.clear()
////        adminList.addAll(adminek)
////        notifyDataSetChanged()
//
//
////        mecze = ""
////        mecze = admin.teams!!
////        mecze = "00010203040506070809101112131415"
//    }






//
//    var mecze: ArrayList<String>? = null
//
//    fun setAdmin(admin: Admin) {
//        mecze = admin.teams
//    }

//
//    var mecze: ArrayList<String>? = null
//
//    fun setAdmin(ArrayList<String>: cosik) {
//        mecze = cosik
//    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false)
        return ContestViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContestViewHolder, i: Int) {

        val imageViewFirstTeam = holder.view.findViewById<ImageView>(R.id.imageViewFirstTeam)
        val imageViewSecondTeam = holder.view.findViewById<ImageView>(R.id.imageViewSecondTeam)
        val textViewFirstTeam = holder.view.findViewById<TextView>(R.id.textViewFirstTeam)
        val textViewResult = holder.view.findViewById<TextView>(R.id.textViewResult)
        val textViewSecondTeam = holder.view.findViewById<TextView>(R.id.textViewSecondTeam)
        val textViewTypeResult = holder.view.findViewById<TextView>(R.id.textViewTypeResult)
        val textViewDate = holder.view.findViewById<TextView>(R.id.textViewDate)



        imageViewFirstTeam.setImageResource(ConstTeamsImage[meczc.substring(4*i, 4*i+2).toInt()])
        imageViewSecondTeam.setImageResource(ConstTeamsImage[meczc.substring(4*i+2, 4*i+4).toInt()])
        textViewFirstTeam.text = ("" + ConstTeams[meczc.substring(4*i, 4*i+2).toInt()])
        textViewResult.text = (RESULTS.substring(4*i, 4*i+2) + " : " + RESULTS.substring(4*i+2, 4*i+4))
        textViewSecondTeam.text = ("" + ConstTeams[meczc.substring(4*i+2, 4*i+4).toInt()])


//
//        imageViewFirstTeam.setImageResource(ConstTeamsImage[CONTEST.substring(4*i, 4*i+2).toInt()])
//        imageViewSecondTeam.setImageResource(ConstTeamsImage[CONTEST.substring(4*i+2, 4*i+4).toInt()])
//        textViewFirstTeam.text = ("" + ConstTeams[CONTEST.substring(4*i, 4*i+2).toInt()])
//        textViewResult.text = (RESULTS.substring(4*i, 4*i+2) + " : " + RESULTS.substring(4*i+2, 4*i+4))
//        textViewSecondTeam.text = ("" + ConstTeams[CONTEST.substring(4*i+2, 4*i+4).toInt()])

//
//        imageViewFirstTeam.setImageResource(ConstTeamsImage[  ConstMatch[i].substring(0, 2).toInt()])
//        imageViewSecondTeam.setImageResource(ConstTeamsImage[ConstMatch[i].substring(2, 4).toInt()])
//        textViewFirstTeam.text = ("" + ConstTeams[ConstMatch[i].substring(0, 2).toInt()])
//        textViewResult.text = (ConstResult[i].substring(0, 2) + " : " + ConstResult[i].substring(2, 4))
//        textViewSecondTeam.text = ("" + ConstTeams[ConstMatch[i].substring(2, 4).toInt()])



        val seek = holder.view.findViewById<SeekBar>(R.id.seekBarTyping)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                textViewTypeResult.text = ((20 + (seek.progress / 2)).toString()
                        + " : " + (70 - (seek.progress / 2)).toString())
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
//                textViewTypeResult.text = seek.progress.toString()
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
//                textViewTypeResult.text = seek.progress.toString()
            }
        })


    }

    override fun getItemCount() = (meczc.length/4) // ConstMatch.size

    inner class ContestViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}



