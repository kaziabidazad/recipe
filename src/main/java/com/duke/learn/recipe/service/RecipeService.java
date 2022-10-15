/**
 * 
 */
package com.duke.learn.recipe.service;

import com.duke.learn.recipe.dto.SearchRecipeRequest;
import com.duke.learn.recipe.dto.SearchRecipeResponse;

/**
 * @author Kazi
 *
 */
public interface RecipeService {

    /**
     * Search recipes based on different criteria.
     * 
     * @param searchRecipeRequest
     * @return
     */
    public SearchRecipeResponse searchRecipes(SearchRecipeRequest searchRecipeRequest);

    public SearchRecipeResponse getAllRecipes();

}
