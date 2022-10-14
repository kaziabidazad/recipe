/**
 * 
 */
package com.duke.learn.recipe.repo;

import java.util.List;

import com.duke.learn.recipe.dto.RecipeDTO;
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
    public default List<Recipe> searchRecipes(RecipeDTO recipeDTO) {
	return null;
    }

    /**
     * 
     * @return all recipes
     */
    public List<Recipe> getAllRecipes();
}
