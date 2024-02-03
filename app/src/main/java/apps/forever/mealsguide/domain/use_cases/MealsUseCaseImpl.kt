package apps.forever.mealsguide.domain.use_cases

import apps.forever.mealsguide.data.MealsApi
import apps.forever.mealsguide.data.dto.MealsDto
import retrofit2.Response

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
class MealsUseCaseImpl(private val mealsApi: MealsApi):MealsUseCase {
    override suspend fun getMeals(): Response<MealsDto> = mealsApi.getMeals()
}