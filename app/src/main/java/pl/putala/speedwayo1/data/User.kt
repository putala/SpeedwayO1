package pl.putala.speedwayo1.data

import java.util.*
import kotlin.collections.ArrayList

data class User(
    val uid: String? = null,
    val name: String? = null,
    var email: String? = null,
    val image: String? = null,
    val points: String? = null,
    val sumOfPoints: String? = null,
    val typedResults: String? = null,
    val date: ArrayList<Date>? = null,

)


