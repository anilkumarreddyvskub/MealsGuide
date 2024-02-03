package apps.forever.mealsguide.domain.use_cases

import apps.forever.mealsguide.data.dto.MealsDto
import retrofit2.Response

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
interface MealsUseCase {
    suspend fun getMeals(): Response<MealsDto>
}