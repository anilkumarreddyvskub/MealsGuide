package apps.forever.mealsguide.ui.mealsscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import apps.forever.mealsguide.R
import apps.forever.mealsguide.databinding.ItemLayoutMealsBinding
import apps.forever.mealsguide.domain.model.Meals

/**
 * Created by Anil Kumar Reddy
 * on 03,February,2024
 */
class MealsAdapter(
    private val mealsData: List<Meals.Meal>,
    val navigateToDetailsScreen: (selectedMeal: Meals.Meal) -> Unit
) : RecyclerView.Adapter<MealsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val binding = DataBindingUtil.inflate<ItemLayoutMealsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_layout_meals, parent, false
        )
        return MealsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mealsData.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        holder.binding.mealData = mealsData[position]
        holder.binding.root.setOnClickListener { navigateToDetailsScreen(mealsData[position]) }
    }
}

class MealsViewHolder(val binding: ItemLayoutMealsBinding) :
    RecyclerView.ViewHolder(binding.root)