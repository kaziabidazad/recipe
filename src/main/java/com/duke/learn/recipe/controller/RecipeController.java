/**
 * 
 */
package com.duke.learn.recipe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duke.learn.recipe.dto.SearchRecipeRequest;
import com.duke.learn.recipe.dto.SearchRecipeResponse;
import com.duke.learn.recipe.service.RecipeService;

/**
 * @author Kazi
 *
 */
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/")
    public Map<String, String> home() {
	Map<String, String> responseMap = new HashMap<>();
	responseMap.put("health", "Good");
	responseMap.put("Code", "Green");
	return responseMap;
    }

    @GetMapping(value = "/allRecipes")
    public SearchRecipeResponse getAllRecipes() {
	return recipeService.getAllRecipes();
    }

    @PostMapping(value = "/searchRecipes")
    public SearchRecipeResponse searchRecipes(@RequestBody SearchRecipeRequest searchRecipeRequest) {
	return recipeService.searchRecipes(searchRecipeRequest);
    }
}
