package apps.forever.mealsguide.ui.mealsscreen

import androidx.lifecycle.ViewModel
import apps.forever.mealsguide.data.dto.MealsDto
import apps.forever.mealsguide.domain.use_cases.MealsUseCase
import apps.forever.mealsguide.util.ApiException
import apps.forever.mealsguide.util.NetworkResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
class MealsViewModel(private val mealsUseCase: MealsUseCase) :ViewModel(){
    fun getMeals() = flow {
        emit(NetworkResponse.Loading(null))
        try {
            val response = mealsUseCase.getMeals()
            if (response.isSuccessful) {
                emit(NetworkResponse.Success(response.body()))
            } else {
                val gson = Gson()
                val type = object : TypeToken<MealsDto>() {}.type
                val errorResponse: MealsDto? =
                    gson.fromJson(response.errorBody()!!.charStream(), type)
                emit(NetworkResponse.Success(errorResponse))
            }
        } catch (e: Exception) {
            throw ApiException(e.message)
        }
    }.catch {
        emit(NetworkResponse.Error(ApiException(it.message)))
    }
}