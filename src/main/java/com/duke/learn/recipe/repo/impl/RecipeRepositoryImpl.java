/**
 * 
 */
package com.duke.learn.recipe.repo.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.duke.learn.recipe.dto.IngredientDTO;
import com.duke.learn.recipe.dto.RecipeDTO;
import com.duke.learn.recipe.entity.Ingredient;
import com.duke.learn.recipe.entity.Recipe;
import com.duke.learn.recipe.repo.RecipeRepository;
import com.duke.learn.recipe.repo.SimpleEntityManager;

/**
 * @author Kazi
 *
 */
@SuppressWarnings("unchecked")
@Repository
public class RecipeRepositoryImpl extends SimpleEntityManager implements RecipeRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeRepositoryImpl.class);

    @Override
    public List<Recipe> searchRecipes(RecipeDTO recipeDTO) {
	List<Recipe> recipes = null;
	if (recipeDTO != null) {
	    // construct the query
	    String recipeNameInput = recipeDTO.getRecipeName();
	    Boolean vegeterianInput = recipeDTO.getVegeterian();
	    Integer servingSizeInput = recipeDTO.getServingSize();
	    String instructionsInput = recipeDTO.getInstructions();
	    List<IngredientDTO> ingredientsInput = recipeDTO.getIngredients();
	    List<IngredientDTO> excludeIngredients = recipeDTO.getExcludeIngredients();
	    StringBuilder queryBuilder = new StringBuilder();
	    queryBuilder.append("Select r from Recipe r ");
	    if ((ingredientsInput != null && !ingredientsInput.isEmpty()))
		queryBuilder.append(" JOIN r.ingredients i ");
	    boolean whereCaluse = false;
	    if (recipeNameInput != null && !recipeNameInput.isBlank()) {
		queryBuilder.append(" where r.name like :name ");
		whereCaluse = true;
	    }
	    if (vegeterianInput != null) {
		if (whereCaluse)
		    queryBuilder.append(" and  ");
		else {
		    whereCaluse = true;
		    queryBuilder.append(" where ");
		}
		queryBuilder.append(" r.vegeterian = :vegeterianInput ");
	    }
	    if (servingSizeInput != null) {
		if (whereCaluse)
		    queryBuilder.append(" and  ");
		else {
		    whereCaluse = true;
		    queryBuilder.append(" where ");
		}
		queryBuilder.append(" r.servingSize = :servingSizeInput ");
	    }
	    if (instructionsInput != null && !instructionsInput.isBlank()) {
		if (whereCaluse)
		    queryBuilder.append(" and  ");
		else {
		    whereCaluse = true;
		    queryBuilder.append(" where ");
		}
		queryBuilder.append(" r.instructions like :instructionsInput ");
	    }
	    if (ingredientsInput != null && !ingredientsInput.isEmpty()) {
		if (whereCaluse)
		    queryBuilder.append(" and  ");
		else {
		    whereCaluse = true;
		    queryBuilder.append(" where ");
		}
		queryBuilder.append(
			" i.ingredient IN (:ingredientsInput) GROUP BY r.id HAVING COUNT(r.id) =:numIngredients ");
	    }
	    if (excludeIngredients != null && !excludeIngredients.isEmpty()) {
		if (whereCaluse)
		    queryBuilder.append(" and  ");
		else
		    queryBuilder.append(" where ");
		queryBuilder.append(
			" NOT EXISTS (SELECT i from r.ingredients i WHERE i.ingredient IN :excludeIngredients ) ");
	    }
	    String queryString = queryBuilder.toString();
	    LOGGER.debug(queryString);
	    Query query = entityManager.createQuery(queryString);
	    if (recipeNameInput != null && !recipeNameInput.isBlank())
		query.setParameter("name", "%" + recipeNameInput + "%");
	    if (vegeterianInput != null)
		query.setParameter("vegeterianInput", vegeterianInput);
	    if (servingSizeInput != null)
		query.setParameter("servingSizeInput", servingSizeInput);
	    if (instructionsInput != null && !instructionsInput.isBlank())
		query.setParameter("instructionsInput", "%" + instructionsInput + "%");
	    if (ingredientsInput != null && !ingredientsInput.isEmpty()) {
		query.setParameter("ingredientsInput",
			ingredientsInput.stream().map(i -> i.getIngredientName()).collect(Collectors.toList()));
		query.setParameter("numIngredients", Long.valueOf(ingredientsInput.size()));
	    }
	    if (excludeIngredients != null && !excludeIngredients.isEmpty()) {
		query.setParameter("excludeIngredients",
			excludeIngredients.stream().map(i -> i.getIngredientName()).collect(Collectors.toList()));
	    }
	    recipes = query.getResultList();
	}
	return recipes;

    }

    @Override
    public List<Recipe> getAllRecipes() {
	List<Recipe> recipes = null;
	recipes = entityManager.createQuery("select r from Recipe r order by r.id").getResultList();
	return recipes;
    }

    @Override
    public List<Ingredient> getIngredients(List<String> ingredientNames) {
	List<Ingredient> ingredients = null;
	ingredients = entityManager.createQuery("Select i from Ingredient i where i.ingredient IN :ingredients")
		.setParameter("ingredients", ingredientNames).getResultList();
	return ingredients;
    }

}
