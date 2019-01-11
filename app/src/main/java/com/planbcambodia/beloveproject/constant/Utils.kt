package com.planbcambodia.beloveproject.constant

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Handler
import android.os.SystemClock
import android.support.v4.content.ContextCompat
import android.view.animation.LinearInterpolator
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        fun getScreenDpi(context: Context) : Float {
            return context.resources.displayMetrics.density;
        }

        fun  formatDate(date: Any, oldFormat: String, newFormat: String): String {
            val oldDateFormat = SimpleDateFormat(oldFormat)
            val newDateFormat = SimpleDateFormat(newFormat)
            var newDateString = ""
            if (date is String) {
                val oldDate = oldDateFormat.parse(date)
                newDateString = newDateFormat.format(oldDate)
            } else if (date is Date) {
                newDateString = newDateFormat.format(date)
            }
            return newDateString
        }

        fun convertImagePath(url: String): String {
            var url = url
            if (!url.contains("facebook") && !url.contains("googleusercontent")) {
                if (url.contains("uploads/")) {
                    url = Constant.BASE_URL + url
                }
            }
            return url
        }
        @Throws(Exception::class)
        fun animateMarker(map: GoogleMap, marker: MarkerOptions, newLatLng: LatLng) {

            val duration: Long = 1000
            val handler = Handler()
            val start = SystemClock.uptimeMillis()
            val proj = map.projection

            val startPoint = proj.toScreenLocation(marker.position)
            val startLatLng = proj.fromScreenLocation(startPoint)

            val interpolator = LinearInterpolator()
            handler.post(object : Runnable {
                override fun run() {
                    var elapsed = SystemClock.uptimeMillis() - start
                    if (elapsed > duration) {
                        elapsed = duration
                    }
                    val t = interpolator.getInterpolation(elapsed.toFloat() / duration)
                    val lng = t * newLatLng.longitude + (1 - t) * startLatLng.longitude
                    val lat = t * newLatLng.latitude + (1 - t) * startLatLng.latitude
                    var latLng = LatLng(lat, lng)
                    marker.position(latLng)
                    if (t < 1.0) {
                        // Post again 10ms later.
                        handler.postDelayed(this, 10)
                    } else {
                        // animation ended
                    }
                }
            })
        }
        fun resizeBitmapMarker(context: Context, res: Int, size: Int): Bitmap {
            val personBitmapDrawable = ContextCompat.getDrawable(context, res) as BitmapDrawable?
            val personBitmap = personBitmapDrawable!!.bitmap
            val height = (size * context.resources.displayMetrics.density).toInt()
            val width = (personBitmap.width.toFloat() / personBitmap.height.toFloat() * height).toInt()
            return Bitmap.createScaledBitmap(personBitmap, width, height, false)
        }

    }

}