package pl.putala.speedwayo1.contest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.putala.speedwayo1.R


class ContestAdapter(private val exampleList: List<ExampleItem>) : RecyclerView.Adapter<ContestAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false)
        return  ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {

        val currentItem = exampleList[position]
        holder.imageView1.setImageResource(currentItem.imageResource1)
        holder.imageView2.setImageResource(currentItem.imageResource2)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
        holder.textView5.text = currentItem.text5

    }



    override fun getItemCount() = exampleList.size


    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView1: ImageView = itemView.findViewById(R.id.imageViewFirstTeam)
        val imageView2: ImageView = itemView.findViewById(R.id.imageViewSecondTeam)
        val textView1: TextView = itemView.findViewById(R.id.textViewFirstTeam)
        val textView2: TextView = itemView.findViewById(R.id.textViewResult)
        val textView3: TextView = itemView.findViewById(R.id.textViewSecondTeam)
        val textView4: TextView = itemView.findViewById(R.id.textViewTypes)
        val textView5: TextView = itemView.findViewById(R.id.textViewDate)

    }


}