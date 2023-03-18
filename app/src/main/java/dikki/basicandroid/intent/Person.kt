package dikki.basicandroid.intent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Making Data Class that implement Parcelable
// U need to override the constructor and other function from Parcelable
// U can use Annotation "@Parcelize" and extends to Parcelable Class
@Parcelize
data class Person(val name: String?, val age: Int?, val email: String?, val city: String?) : Parcelable