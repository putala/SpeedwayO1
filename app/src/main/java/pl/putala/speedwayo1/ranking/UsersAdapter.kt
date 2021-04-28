package pl.putala.speedwayo1.ranking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.data.User



class UsersAdapter(private val listener: UsersActivity): RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private val usersList = ArrayList<User>()

    fun setUsers(list: List<User>){
        usersList.clear()
        usersList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        bindData(holder, position)
    }

    private fun bindData(holder: UsersViewHolder, i: Int) {
        val name = holder.itemView.findViewById<TextView>(R.id.textViewUserName)
        val points = holder.itemView.findViewById<TextView>(R.id.textViewPoints)
        val position = holder.itemView.findViewById<TextView>(R.id.textViewPosition)
        val image = holder.itemView.findViewById<ImageView>(R.id.imageViewUserImage)

        if (i<9) {
            position.text = "0" + (i+1)
        } else {
            position.text = "" + (i+1)
        }

        name.text = usersList[holder.absoluteAdapterPosition].name
        points.text = usersList[holder.absoluteAdapterPosition].sumOfPoints


        // carImage   -> potem :-)

    }

    override fun getItemCount() = usersList.size


    inner class UsersViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        init {
            view.setOnLongClickListener {
                listener.onUserLongClick(usersList[absoluteAdapterPosition], absoluteAdapterPosition)
                true
            }
        }
    }
}



interface OnUserItemLongClick{
    fun onCarLongClick(user: User, position: Int)
}



