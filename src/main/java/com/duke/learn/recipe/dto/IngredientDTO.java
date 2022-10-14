/**
 * 
 */
package com.duke.learn.recipe.dto;

/**
 * @author Kazi
 *
 */
public class IngredientDTO implements CommonInput {

    private Integer ingredientId;
    private String ingredientNameString;

    /**
     * @return the ingredientId
     */
    public Integer getIngredientId() {
	return ingredientId;
    }

    /**
     * @param ingredientId the ingredientId to set
     */
    public void setIngredientId(Integer ingredientId) {
	this.ingredientId = ingredientId;
    }

    /**
     * @return the ingredientNameString
     */
    public String getIngredientNameString() {
	return ingredientNameString;
    }

    /**
     * @param ingredientNameString the ingredientNameString to set
     */
    public void setIngredientNameString(String ingredientNameString) {
	this.ingredientNameString = ingredientNameString;
    }

    @Override
    public String toString() {
	return "Ingredients [ingredientId=" + ingredientId + ", ingredientNameString=" + ingredientNameString + "]";
    }

}
