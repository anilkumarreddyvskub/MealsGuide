package apps.forever.mealsguide.di

import apps.forever.mealsguide.data.MealsApi
import apps.forever.mealsguide.domain.use_cases.MealsUseCase
import apps.forever.mealsguide.domain.use_cases.MealsUseCaseImpl
import apps.forever.mealsguide.ui.mealsscreen.MealsViewModel
import apps.forever.mealsguide.ui.mealsscreen.MealsAdapter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
val mealsModule = module {
    viewModel {
        MealsViewModel(get())
    }
    single<MealsApi> {
        get<Retrofit>().create(MealsApi::class.java)
    }

    single<MealsUseCase> {
        MealsUseCaseImpl(get())
    }

    factory { params ->
        MealsAdapter(params.get(),params.get())
    }
}