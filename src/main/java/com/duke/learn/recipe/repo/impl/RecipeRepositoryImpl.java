/**
 * 
 */
package com.duke.learn.recipe.repo.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.duke.learn.recipe.entity.Recipe;
import com.duke.learn.recipe.repo.RecipeRepository;
import com.duke.learn.recipe.repo.SimpleEntityManager;

/**
 * @author Kazi
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class RecipeRepositoryImpl extends SimpleEntityManager implements RecipeRepository {

    @Override
    public List<Recipe> getAllRecipes() {
	List<Recipe> recipes = null;
	recipes = (List<Recipe>) entityManager.createQuery("select r from Recipe r order by r.id").getResultList();
	return recipes;
    }

}
