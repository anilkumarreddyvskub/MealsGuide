package apps.forever.mealsguide.di

import apps.forever.mealsguide.MealsGuideApplication
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import org.koin.core.module.Module

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
fun getAppKoinLayer(app: MealsGuideApplication) = GlobalContext.startKoin {
    androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
    androidContext(app)
    modules(moduleList)
}

val moduleList = listOf<Module>(
    networkModule,
    mealsModule
)