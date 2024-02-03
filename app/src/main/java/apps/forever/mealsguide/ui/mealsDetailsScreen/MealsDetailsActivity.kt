package apps.forever.mealsguide.ui.mealsDetailsScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import apps.forever.mealsguide.R
import apps.forever.mealsguide.databinding.ActivityMealsDetailsBinding
import apps.forever.mealsguide.domain.model.Meals
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MealsDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMealsDetailsBinding
    lateinit var meal: Meals.Meal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setHomeButtonEnabled(true)
        setClickListeners()
        setData()
    }

    private fun setClickListeners() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setData() {
        val listType = object : TypeToken<Meals.Meal?>() {}.type
        meal = Gson().fromJson(intent.getStringExtra("meal"), listType)

        if (::meal.isInitialized) {
            binding.selectedMeal = meal
        } else {
            Toast.makeText(
                this@MealsDetailsActivity,
                getString(R.string.something_went_wrong),
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }
    }
}