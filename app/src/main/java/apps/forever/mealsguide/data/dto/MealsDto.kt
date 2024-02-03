package apps.forever.mealsguide.data.dto

import apps.forever.mealsguide.domain.model.Meals
import com.google.gson.annotations.SerializedName

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */

data class MealsDto(
    @SerializedName("meals")
    var meals: List<MealDto>
) {
    data class MealDto(
        @SerializedName("idMeal")
        var idMeal: String? = null,
        @SerializedName("strMeal")
        var strMeal: String? = null,
        @SerializedName("strDrinkAlternate")
        var strDrinkAlternate: String? = null,
        @SerializedName("strCategory")
        var strCategory: String? = null,
        @SerializedName("strArea")
        var strArea: String? = null,
        @SerializedName("strInstructions")
        var strInstructions: String? = null,
        @SerializedName("strMealThumb")
        var strMealThumb: String? = null,
        @SerializedName("strTags")
        var strTags: String? = null,
        @SerializedName("strYoutube")
        var strYoutube: String? = null,
        @SerializedName("strIngredient1")
        var strIngredient1: String? = null,
        @SerializedName("strIngredient2")
        var strIngredient2: String? = null,
        @SerializedName("strIngredient3")
        var strIngredient3: String? = null,
        @SerializedName("strIngredient4")
        var strIngredient4: String? = null,
        @SerializedName("strIngredient5")
        var strIngredient5: String? = null,
        @SerializedName("strIngredient6")
        var strIngredient6: String? = null,
        @SerializedName("strIngredient7")
        var strIngredient7: String? = null,
        @SerializedName("strIngredient8")
        var strIngredient8: String? = null,
        @SerializedName("strIngredient9")
        var strIngredient9: String? = null,
        @SerializedName("strIngredient10")
        var strIngredient10: String? = null,
        @SerializedName("strIngredient11")
        var strIngredient11: String? = null,
        @SerializedName("strIngredient12")
        var strIngredient12: String? = null,
        @SerializedName("strIngredient13")
        var strIngredient13: String? = null,
        @SerializedName("strIngredient14")
        var strIngredient14: String? = null,
        @SerializedName("strIngredient15")
        var strIngredient15: String? = null,
        @SerializedName("strIngredient16")
        var strIngredient16: String? = null,
        @SerializedName("strIngredient17")
        var strIngredient17: String? = null,
        @SerializedName("strIngredient18")
        var strIngredient18: String? = null,
        @SerializedName("strIngredient19")
        var strIngredient19: String? = null,
        @SerializedName("strIngredient20")
        var strIngredient20: String? = null,
        @SerializedName("strMeasure1")
        var strMeasure1: String? = null,
        @SerializedName("strMeasure2")
        var strMeasure2: String? = null,
        @SerializedName("strMeasure3")
        var strMeasure3: String? = null,
        @SerializedName("strMeasure4")
        var strMeasure4: String? = null,
        @SerializedName("strMeasure5")
        var strMeasure5: String? = null,
        @SerializedName("strMeasure6")
        var strMeasure6: String? = null,
        @SerializedName("strMeasure7")
        var strMeasure7: String? = null,
        @SerializedName("strMeasure8")
        var strMeasure8: String? = null,
        @SerializedName("strMeasure9")
        var strMeasure9: String? = null,
        @SerializedName("strMeasure10")
        var strMeasure10: String? = null,
        @SerializedName("strMeasure11")
        var strMeasure11: String? = null,
        @SerializedName("strMeasure12")
        var strMeasure12: String? = null,
        @SerializedName("strMeasure13")
        var strMeasure13: String? = null,
        @SerializedName("strMeasure14")
        var strMeasure14: String? = null,
        @SerializedName("strMeasure15")
        var strMeasure15: String? = null,
        @SerializedName("strMeasure16")
        var strMeasure16: String? = null,
        @SerializedName("strMeasure17")
        var strMeasure17: String? = null,
        @SerializedName("strMeasure18")
        var strMeasure18: String? = null,
        @SerializedName("strMeasure19")
        var strMeasure19: String? = null,
        @SerializedName("strMeasure20")
        var strMeasure20: String? = null,
        @SerializedName("strSource")
        var strSource: String? = null,
        @SerializedName("strImageSource")
        var strImageSource: String? = null,
        @SerializedName("strCreativeCommonsConfirmed")
        var strCreativeCommonsConfirmed: String? = null,
        @SerializedName("dateModified")
        var dateModified: String? = null
    )
}

fun MealsDto.toMeals(): Meals {
    val mealsList = meals.map { mealDto ->
        Meals.Meal(
            idMeal = mealDto.idMeal,
            strMeal = mealDto.strMeal,
            strDrinkAlternate = mealDto.strDrinkAlternate,
            strCategory = mealDto.strCategory,
            strArea = mealDto.strArea,
            strInstructions = mealDto.strInstructions,
            strMealThumb = mealDto.strMealThumb,
            strTags = mealDto.strTags,
            strYoutube = mealDto.strYoutube,
            strIngredient1 = mealDto.strIngredient1,
            strIngredient2 = mealDto.strIngredient2,
            strIngredient3 = mealDto.strIngredient3,
            strIngredient4 = mealDto.strIngredient4,
            strIngredient5 = mealDto.strIngredient5,
            strIngredient6 = mealDto.strIngredient6,
            strIngredient7 = mealDto.strIngredient7,
            strIngredient8 = mealDto.strIngredient8,
            strIngredient9 = mealDto.strIngredient9,
            strIngredient10 = mealDto.strIngredient10,
            strIngredient11 = mealDto.strIngredient11,
            strIngredient12 = mealDto.strIngredient12,
            strIngredient13 = mealDto.strIngredient13,
            strIngredient14 = mealDto.strIngredient14,
            strIngredient15 = mealDto.strIngredient15,
            strIngredient16 = mealDto.strIngredient16,
            strIngredient17 = mealDto.strIngredient17,
            strIngredient18 = mealDto.strIngredient18,
            strIngredient19 = mealDto.strIngredient19,
            strIngredient20 = mealDto.strIngredient20,
            strMeasure1 = mealDto.strMeasure1,
            strMeasure2 = mealDto.strMeasure2,
            strMeasure3 = mealDto.strMeasure3,
            strMeasure4 = mealDto.strMeasure4,
            strMeasure5 = mealDto.strMeasure5,
            strMeasure6 = mealDto.strMeasure6,
            strMeasure7 = mealDto.strMeasure7,
            strMeasure8 = mealDto.strMeasure8,
            strMeasure9 = mealDto.strMeasure9,
            strMeasure10 = mealDto.strMeasure10,
            strMeasure11 = mealDto.strMeasure11,
            strMeasure12 = mealDto.strMeasure12,
            strMeasure13 = mealDto.strMeasure13,
            strMeasure14 = mealDto.strMeasure14,
            strMeasure15 = mealDto.strMeasure15,
            strMeasure16 = mealDto.strMeasure16,
            strMeasure17 = mealDto.strMeasure17,
            strMeasure18 = mealDto.strMeasure18,
            strMeasure19 = mealDto.strMeasure19,
            strMeasure20 = mealDto.strMeasure20,
            strSource = mealDto.strSource,
            strImageSource = mealDto.strImageSource,
            strCreativeCommonsConfirmed = mealDto.strCreativeCommonsConfirmed,
            dateModified = mealDto.dateModified
        )
    }
    return Meals(mealsList)
}