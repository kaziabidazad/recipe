/**
 * 
 */
package com.duke.learn.recipe.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duke.learn.recipe.dto.IngredientDTO;
import com.duke.learn.recipe.dto.RecipeDTO;
import com.duke.learn.recipe.dto.SearchRecipeResponse;
import com.duke.learn.recipe.entity.Recipe;
import com.duke.learn.recipe.repo.RecipeRepository;
import com.duke.learn.recipe.service.RecipeService;

/**
 * @author Kazi
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public SearchRecipeResponse getAllRecipes() {
	SearchRecipeResponse response = new SearchRecipeResponse();
	List<RecipeDTO> recipeDTOs = null;
	List<Recipe> recipes = recipeRepository.getAllRecipes();
	if (recipes != null)
	    recipeDTOs = recipes.stream().map(r -> {
		RecipeDTO dto = new RecipeDTO();
		dto.setRecipeId(r.getId());
		dto.setRecipeName(r.getName());
		dto.setVegeterian(r.isVegeterian());
		dto.setServingSize(r.getServingSize());
		dto.setInstructions(r.getInstructions());
		if (r.getIngredients() != null)
		    dto.setIngredients(r.getIngredients().stream().map(i -> {
			IngredientDTO iDto = new IngredientDTO();
			iDto.setIngredientId(i.getId());
			iDto.setIngredientNameString(i.getIngredient());
			return iDto;
		    }).collect(Collectors.toList()));

		return dto;
	    }).collect(Collectors.toList());
	response.setRecipes(recipeDTOs);
	return response;
    }

}
