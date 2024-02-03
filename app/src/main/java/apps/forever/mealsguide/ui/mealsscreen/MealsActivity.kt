package apps.forever.mealsguide.ui.mealsscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import apps.forever.mealsguide.R
import apps.forever.mealsguide.data.dto.MealsDto
import apps.forever.mealsguide.data.dto.toMeals
import apps.forever.mealsguide.databinding.ActivityMealsBinding
import apps.forever.mealsguide.domain.model.Meals
import apps.forever.mealsguide.ui.mealsDetailsScreen.MealsDetailsActivity
import apps.forever.mealsguide.util.NetworkResponse
import apps.forever.mealsguide.util.RecyclerviewGridLayoutMarginItemDecoration
import apps.forever.mealsguide.util.isNetConnected
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MealsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMealsBinding
    private val mealsViewModel: MealsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchMealsData()
    }

    private fun fetchMealsData() {
        if (isNetConnected(this@MealsActivity)) {
            lifecycleScope.launch {
                mealsViewModel.getMeals().collect { it ->
                    when (it.status) {
                        NetworkResponse.STATUS.INPROGRESS -> {
                            showLoader()
                        }

                        NetworkResponse.STATUS.SUCCESS -> {
                            val data = it.data as MealsDto
                            val mealsData = data.toMeals()
                            setupRecyclerView(mealsData.meals)
                            showData()
                        }

                        NetworkResponse.STATUS.ERROR -> {
                           showError(resources.getString(R.string.something_went_wrong))
                        }
                    }
                }
            }
        } else {
            showError(resources.getString(R.string.no_internet))
        }
    }

    private fun setupRecyclerView(mealsData: List<Meals.Meal>) {
        val mealsAdapter: MealsAdapter by inject {
            parametersOf(
                mealsData, ::navigateToDetailsScreen
            )
        }
        binding.rvMeals.apply {
            adapter = mealsAdapter
            layoutManager = GridLayoutManager(
                this@MealsActivity, 2,
                LinearLayoutManager.VERTICAL, false
            )
            addItemDecoration(
                RecyclerviewGridLayoutMarginItemDecoration(
                    resources.getDimensionPixelSize(
                        R.dimen.size_8_dp
                    ), 2, GridLayoutManager.VERTICAL
                )
            )
        }

    }

    private fun showData() {
        binding.pbVisiblity = false
        binding.errorVisiblity = false
        binding.mealsVisiblity = true
    }

    private fun showLoader() {
        binding.pbVisiblity = true
        binding.errorVisiblity = false
        binding.mealsVisiblity = false
    }

    private fun showError(errorMsg:String) {
        binding.pbVisiblity = false
        binding.errorVisiblity = true
        binding.mealsVisiblity = false
        val snackbar = Snackbar
            .make(binding.root, errorMsg, Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    private fun navigateToDetailsScreen(meal: Meals.Meal) {
        var intent = Intent(this, MealsDetailsActivity::class.java)
        intent.putExtra("meal", Gson().toJson(meal))
        startActivity(intent)
    }
}