/**
 * 
 */
package com.duke.learn.recipe.repo;

import java.util.List;

import com.duke.learn.recipe.dto.RecipeDTO;
import com.duke.learn.recipe.entity.Ingredient;
import com.duke.learn.recipe.entity.Recipe;

/**
 * @author Kazi
 *
 */
public interface RecipeRepository {

    /**
     * 
     * @param recipeDTO
     * @return matched recipes
     */
    public List<Recipe> searchRecipes(RecipeDTO recipeDTO);

    /**
     * 
     * @return all recipes
     */
    public List<Recipe> getAllRecipes();

    /**
     * Search ingredients based on ingredient names
     * 
     * @param ingredientNames
     * @return
     */
    public List<Ingredient> getIngredients(List<String> ingredientNames);
}
