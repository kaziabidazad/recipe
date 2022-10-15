/**
 * 
 */
package com.duke.learn.recipe.dto;

import java.util.List;

/**
 * @author Kazi
 *
 */
public class SearchRecipeResponse extends CommonResponse implements CommonOutput {

    private List<RecipeDTO> recipes;

    /**
     * @return the recipes
     */
    public List<RecipeDTO> getRecipes() {
	return recipes;
    }

    /**
     * @param recipes the recipes to set
     */
    public void setRecipes(List<RecipeDTO> recipes) {
	this.recipes = recipes;
    }

    @Override
    public String toString() {
	return "SearchRecipeResponse [recipes=" + recipes + "]";
    }

}
