package com.asmat.rolando.bakingapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.asmat.rolando.bakingapp.R
import com.asmat.rolando.bakingapp.adapters.RecipeDetailsPagerAdapter
import com.asmat.rolando.bakingapp.fragments.IngredientsFragment
import com.asmat.rolando.bakingapp.models.Ingredient
import com.asmat.rolando.bakingapp.models.Recipe

class RecipeDetails : AppCompatActivity(), IngredientsFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: Ingredient) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print(item)
    }

    var mPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
        val recipe = intent.getParcelableExtra<Recipe>(MainActivity.ARG_RECIPE)
        supportActionBar?.title = recipe.name
        val adapter = RecipeDetailsPagerAdapter(supportFragmentManager)
        adapter.recipe = recipe
        mPager = findViewById(R.id.container) as ViewPager
        mPager?.setAdapter(adapter)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}