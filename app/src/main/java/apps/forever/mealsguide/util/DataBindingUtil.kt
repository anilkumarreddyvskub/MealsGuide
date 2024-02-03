package apps.forever.mealsguide.util


import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
@BindingAdapter("android:imgResCircular")
fun setImgResCircular(view: ImageView, url: String) {
    Picasso.get().load(url)
        .into(view, object : Callback {
            override fun onSuccess() {
                val imageBitmap = (view.drawable as BitmapDrawable).bitmap
                val imageDrawable =
                    RoundedBitmapDrawableFactory.create(view.context.resources, imageBitmap)
                imageDrawable.isCircular = true
                imageDrawable.cornerRadius = Math.max(imageBitmap.width, imageBitmap.height) / 2.0f
                view.setImageDrawable(imageDrawable)
            }

            override fun onError(e: Exception?) {
                view.setImageResource(apps.forever.mealsguide.R.drawable.baseline_broken_image_24)
            }
        })
}

@BindingAdapter("android:imgRes")
fun setImgRes(view: ImageView, url: String) {
    Picasso.get().load(url)
        .into(view)
}