package pl.putala.speedwayo1.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.data.Car

class CarAdapter(private val listener: HomeActivity): RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    private val carsList = ArrayList<Car>()

    fun setCars(list: List<Car>){
        carsList.clear()
        carsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_row, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        bindData(holder)
    }

    private fun bindData(holder: CarViewHolder) {
        val name = holder.itemView.findViewById<TextView>(R.id.carName)
        val productionYear = holder.itemView.findViewById<TextView>(R.id.carProductionYear)
        val image = holder.itemView.findViewById<ImageView>(R.id.carImage)

        name.text = carsList[holder.absoluteAdapterPosition].name
        productionYear.text = carsList[holder.absoluteAdapterPosition].productionYear
        // carImage   -> potem :-)

    }

    override fun getItemCount() = carsList.size


    inner class CarViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        init {
            view.setOnLongClickListener {
                listener.onCarLongClick(carsList[absoluteAdapterPosition], absoluteAdapterPosition)
                true
            }
        }
    }


    // class ContestViewHolder(val view: View): RecyclerView.ViewHolder(view)


}


interface OnCarItemLongClick{
    fun onCarLongClick(car: Car, position: Int)
}



