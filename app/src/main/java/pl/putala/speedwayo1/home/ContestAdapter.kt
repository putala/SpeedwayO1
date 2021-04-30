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
import pl.putala.speedwayo1.Constant.ConstTeamsImage
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.data.Admin
import pl.putala.speedwayo1.data.User
import pl.putala.speedwayo1.home.ProfileViewModel
import kotlin.math.abs


class ContestAdapter : RecyclerView.Adapter<ContestAdapter.ContestViewHolder>() {

    private var contest = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
    private var results = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
    private val PROFILE_DEBUG = "PROFILE_DEBUG"
    private val PROFILE_DEBUG_P = "PROFILE_DEBUG_P"
    private var typedResults = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
    private var pointsString = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
    private var sumOfPoints = 0
    private var sumOfPointsString = ""
    private var tempPoints = 0
    private var tempPointsString = ""
    private var typA = 0
    private var typB = 0
    private var visibilityBar = SeekBar.INVISIBLE


    fun getAdmin(admin: Admin?) {
        if (admin != null) {
            contest = admin.teams.toString()
            results = admin.results.toString()
            if (admin.visibilityBar.toString() == "VISIBLE") {
                visibilityBar = SeekBar.VISIBLE
            }
//            Log.d(PROFILE_DEBUG, contest)
            notifyDataSetChanged()
        }
    }

    fun getUser(user: User?) {
        if (user != null) {
            typedResults = user.typedResults.toString()
            pointsString = user.points.toString()
            sumOfPointsString = user.sumOfPoints.toString()
            sumOfPoints = sumOfPointsString.toInt()
            Log.d(PROFILE_DEBUG, typedResults)
            notifyDataSetChanged()
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false)
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



        imageViewFirstTeam.setImageResource(ConstTeamsImage[contest.substring(4 * i, 4 * i + 2).toInt()])
        imageViewSecondTeam.setImageResource(ConstTeamsImage[contest.substring(4 * i + 2, 4 * i + 4).toInt()])
        textViewFirstTeam.text = ("" + ConstTeams[contest.substring(4 * i, 4 * i + 2).toInt()])
        textViewResult.text = (results.substring(4 * i, 4 * i + 2) + " : " + results.substring(4 * i + 2, 4 * i + 4))
        textViewSecondTeam.text = ("" + ConstTeams[contest.substring(4 * i + 2, 4 * i + 4).toInt()])
        textViewTypeResult.text = (typedResults.substring(4 * i, 4 * i + 2) + " : " + typedResults.substring(4 * i + 2, 4 * i + 4))
        typA = typedResults.substring(4 * i, 4 * i + 2).toInt()
        typB = typedResults.substring(4 * i + 2, 4 * i + 4).toInt()

        val seek = holder.view.findViewById<SeekBar>(R.id.seekBarTyping)
        seek.progress = 2 * (typA - 20)


        if ((results.substring(4 * i, 4 * i + 2)) != "00" ||  (results.substring(4 * i + 2, 4 * i + 4)) != "00"){
            seek.visibility = visibilityBar
            if (typA != 0){
                tempPoints = 0
                if (((results.substring(4*i, 4*i+2).toInt()) - (results.substring(4*i+2, 4*i+4).toInt()) == 0)
                    && (typA - typB == 0)){
                    tempPoints = 70
                } else if (((results.substring(4*i, 4*i+2).toInt())-(results.substring(4*i+2, 4*i+4).toInt()))*(typA-typB)>0) {
                    tempPoints = 50 - abs(((results.substring(4 * i, 4 * i + 2).toInt()) - (results.substring(4 * i + 2, 4 * i + 4).toInt())) - (typA - typB))
                    if (results.substring(4*i, 4*i+2).toInt() == typA){
                        tempPoints += 20
                    }
                }
                tempPointsString = when {
                    tempPoints < 10 -> {
                        "000$tempPoints"
                    }
                    tempPoints < 100 -> {
                        "00$tempPoints"
                    }
                    tempPoints < 1000 -> {
                        "0$tempPoints"
                    }
                    else -> {
                        "$tempPoints"
                    }
                }
                pointsString = pointsString.substring(0, 4 * i) + tempPointsString + pointsString.substring(4 * i + 4, pointsString.length)
                sumOfPoints = 0
                for (j in 0 until (pointsString.length/4).toInt()) {
                    sumOfPoints += pointsString.substring(4 * j, 4 * j + 4).toInt()
                }
            }
        } else {
            seek.visibility = SeekBar.VISIBLE
        }


        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                typA = (20 + (seek.progress / 2))
                typB = (70 - (seek.progress / 2))
                textViewTypeResult.text = "$typA : $typB"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
//                textViewTypeResult.text = seek.progress.toString()
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
//                textViewTypeResult.text = seek.progress.toString()
                Log.d(PROFILE_DEBUG_P, typedResults)
                typedResults = typedResults.substring(0, 4 * i) + typA + typB + typedResults.substring(4 * i + 4, typedResults.length)
                Log.d(PROFILE_DEBUG_P, typedResults)

            }
        })

    }

    override fun getItemCount() = (contest.length / 4)

    fun editUser(userVm: ProfileViewModel) {
        sumOfPointsString = when {
            sumOfPoints<10 -> {
                "000$sumOfPoints"
            }
            sumOfPoints<100 -> {
                "00$sumOfPoints"
            }
            sumOfPoints<1000 -> {
                "0$sumOfPoints"
            }
            else -> {
                "$sumOfPoints"
            }
        }
        val map = mapOf("points" to pointsString, "typedResults" to typedResults, "sumOfPoints" to sumOfPointsString)
        Thread.sleep(100)
        userVm.editProfileData(map)
        Thread.sleep(100)
    }

    inner class ContestViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}



