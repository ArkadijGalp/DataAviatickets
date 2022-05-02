package space.arkady.aviaticketsdao.utils

import android.app.AlertDialog
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import space.arkady.aviaticketsdao.R
import space.arkady.aviaticketsdao.domain.models.FlightTicket
import java.text.SimpleDateFormat
import java.util.*

fun Int.toPassengerAge(): FlightTicket.PassengerAge {
    return when (this) {
        0 -> FlightTicket.PassengerAge.CHILD
        1 -> FlightTicket.PassengerAge.ADULT
        else -> throw IllegalStateException("Wrong type")
    }
}

fun Int.getValuePassengerAge(): Int {
    return when (this) {
        0 -> R.string.child
        1 -> R.string.adult
        else -> throw IllegalStateException("Wrong value parameter")
    }
}

fun String.checkValidPassport(): Boolean {
    return Regex(Constant.VALIDATE_PASSPORT_FORMAT).matches(this)
}

fun Date.fromDateToString(): String {
    return SimpleDateFormat(Constant.DATE_FORMAT, Locale.ENGLISH).format(this)
}

fun Fragment.dialog(
    message: String,
    context: Context,
    onPositiveButtonClick: () -> Unit,
    onNegativeButtonClick: () -> Unit
) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle("Warning!")
        .setMessage(message)
        .setCancelable(true)
        .setPositiveButton("Affirmative") { dialogMessage, _ ->
            onPositiveButtonClick()
            dialogMessage.cancel()
        }
        .setNegativeButton("Cancel") { dialogMessage, _ ->
            onNegativeButtonClick()
            dialogMessage.cancel()
        }
    builder.show()
}

fun showSnack(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}


fun FragmentActivity.openFragment(idFrameFragment: Int, fragment: Fragment, tag: String) {
    supportFragmentManager
        .beginTransaction()
        .replace(idFrameFragment, fragment, tag)
        .addToBackStack(tag)
        .commit()
}
