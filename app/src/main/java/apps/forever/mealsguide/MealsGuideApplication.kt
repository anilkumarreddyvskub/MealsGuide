package apps.forever.mealsguide

import android.app.Application
import apps.forever.mealsguide.di.getAppKoinLayer

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
class MealsGuideApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        getAppKoinLayer(this@MealsGuideApplication)
    }
}