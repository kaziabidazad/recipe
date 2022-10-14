/**
 * 
 */
package com.duke.learn.recipe.dto;

import java.util.List;

/**
 * @author Kazi
 *
 */
public class RecipeDTO implements CommonInput {

    private Integer recipeId;

    private String recipeName;

    private Boolean vegeterian;

    private Integer servingSize;

    private String instructions;

    private List<IngredientDTO> ingredients;

    /**
     * @return the recipeId
     */
    public Integer getRecipeId() {
	return recipeId;
    }

    /**
     * @param recipeId the recipeId to set
     */
    public void setRecipeId(Integer recipeId) {
	this.recipeId = recipeId;
    }

    /**
     * @return the recipeName
     */
    public String getRecipeName() {
	return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
	this.recipeName = recipeName;
    }

    /**
     * @return the vegeterian
     */
    public Boolean isVegeterian() {
	return vegeterian;
    }

    /**
     * @param vegeterian the vegeterian to set
     */
    public void setVegeterian(Boolean vegeterian) {
	this.vegeterian = vegeterian;
    }

    /**
     * @return the servingSize
     */
    public Integer getServingSize() {
	return servingSize;
    }

    /**
     * @param servingSize the servingSize to set
     */
    public void setServingSize(Integer servingSize) {
	this.servingSize = servingSize;
    }

    /**
     * @return the instructions
     */
    public String getInstructions() {
	return instructions;
    }

    /**
     * @param instructions the instructions to set
     */
    public void setInstructions(String instructions) {
	this.instructions = instructions;
    }

    /**
     * @return the ingredients
     */
    public List<IngredientDTO> getIngredients() {
	return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(List<IngredientDTO> ingredients) {
	this.ingredients = ingredients;
    }

    @Override
    public String toString() {
	return "RecipeRequest [recipeId=" + recipeId + ", recipeName=" + recipeName + ", vegeterian=" + vegeterian
		+ ", servingSize=" + servingSize + ", instructions=" + instructions + ", ingredients=" + ingredients
		+ "]";
    }

}
