/**
 * 
 */
package com.duke.learn.recipe.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duke.learn.recipe.dto.IngredientDTO;
import com.duke.learn.recipe.dto.RecipeDTO;
import com.duke.learn.recipe.dto.SearchRecipeRequest;
import com.duke.learn.recipe.dto.SearchRecipeResponse;
import com.duke.learn.recipe.entity.Ingredient;
import com.duke.learn.recipe.entity.Recipe;
import com.duke.learn.recipe.repo.RecipeRepository;
import com.duke.learn.recipe.service.RecipeService;
import com.duke.learn.recipe.util.Status;

/**
 * @author Kazi
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public SearchRecipeResponse searchRecipes(SearchRecipeRequest searchRecipeRequest) {
	SearchRecipeResponse recipeResponse = new SearchRecipeResponse();
	String message = null;
	Status status = Status.FAILURE;
	if (searchRecipeRequest != null) {
	    RecipeDTO recipeDTO = searchRecipeRequest.getRecipeQuery();
	    if (recipeDTO != null) {
		List<RecipeDTO> recipeResults = convertRecipeEntityToViewObject(
			recipeRepository.searchRecipes(recipeDTO));
		recipeResponse.setRecipes(recipeResults);
		status = Status.SUCCESS;
	    } else {
		message = "No query, please enter the fields based on which you want to filter.";
	    }
	} else {
	    message = "No query, please enter the fields based on which you want to filter.";
	}
	recipeResponse.setStatus(status);
	recipeResponse.setMessage(message);
	return recipeResponse;
    }

    @Override
    public SearchRecipeResponse getAllRecipes() {
	SearchRecipeResponse response = new SearchRecipeResponse();
	List<RecipeDTO> recipeDTOs = null;
	List<Recipe> recipes = recipeRepository.getAllRecipes();
	recipeDTOs = convertRecipeEntityToViewObject(recipes);
	response.setRecipes(recipeDTOs);
	return response;
    }

    public static List<RecipeDTO> convertRecipeEntityToViewObject(List<Recipe> recipes) {
	List<RecipeDTO> recipeDTOs = null;
	if (recipes != null) {
	    recipeDTOs = recipes.stream().map(r -> {
		RecipeDTO dto = new RecipeDTO();
		dto.setRecipeId(r.getId());
		dto.setRecipeName(r.getName());
		dto.setVegeterian(r.isVegeterian());
		dto.setServingSize(r.getServingSize());
		dto.setInstructions(r.getInstructions());
		if (r.getIngredients() != null)
		    dto.setIngredients(convertIngredientEntityToViewObject(r.getIngredients()));
		return dto;
	    }).collect(Collectors.toList());
	}
	return recipeDTOs;
    }

    public static List<IngredientDTO> convertIngredientEntityToViewObject(Set<Ingredient> ingredients) {
	List<IngredientDTO> ingredientDTOs = null;
	if (ingredients != null) {
	    ingredientDTOs = ingredients.stream().filter(i -> i != null).map(i -> {
		IngredientDTO iDto = new IngredientDTO();
		iDto.setIngredientId(i.getId());
		iDto.setIngredientName(i.getIngredient());
		return iDto;
	    }).collect(Collectors.toList());
	}
	return ingredientDTOs;
    }
}
