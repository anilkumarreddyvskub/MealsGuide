package apps.forever.mealsguide.data

import apps.forever.mealsguide.data.dto.MealsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
interface MealsApi {
    @GET("search.php")
    suspend fun getMeals(@Query("s") s: String="Chicken"): Response<MealsDto>
}