/**
 * 
 */
package com.duke.learn.recipe.dto;

/**
 * @author Kazi
 *
 */
public class SearchRecipeRequest implements CommonRequest {

    private RecipeDTO recipeQuery;

    /**
     * @return the recipeQuery
     */
    public RecipeDTO getRecipeQuery() {
	return recipeQuery;
    }

    /**
     * @param recipeQuery the recipeQuery to set
     */
    public void setRecipeQuery(RecipeDTO recipeQuery) {
	this.recipeQuery = recipeQuery;
    }

    @Override
    public String toString() {
	return "SearchRecipeRequest [recipeQuery=" + recipeQuery + "]";
    }

}
