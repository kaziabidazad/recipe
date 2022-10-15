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
    private String ingredientName;

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
     * @return the ingredientName
     */
    public String getIngredientName() {
	return ingredientName;
    }

    /**
     * @param ingredientName the ingredientName to set
     */
    public void setIngredientName(String ingredientNameString) {
	this.ingredientName = ingredientNameString;
    }

    @Override
    public String toString() {
	return "Ingredients [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName + "]";
    }

}
