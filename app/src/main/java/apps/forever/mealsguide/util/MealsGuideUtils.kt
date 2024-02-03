package apps.forever.mealsguide.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */

fun isNetConnected(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = connectivityManager.activeNetworkInfo
    return info != null && info.isAvailable && info.isConnected
}