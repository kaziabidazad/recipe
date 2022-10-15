/**
 * 
 */
package com.duke.learn.recipe.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Kazi
 *
 */
@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable {

    private static final long serialVersionUID = -4002260545626515507L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id")
    private Integer id;

    @Column(name = "name")
    private String ingredient;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Recipe> recipes;

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the ingredient
     */
    public String getIngredient() {
	return ingredient;
    }

    /**
     * @param ingredient the ingredient to set
     */
    public void setIngredient(String ingredient) {
	this.ingredient = ingredient;
    }

    /**
     * @return the recipes
     */
    public Set<Recipe> getRecipes() {
	return recipes;
    }

    /**
     * @param recipes the recipes to set
     */
    public void setRecipes(Set<Recipe> recipes) {
	this.recipes = recipes;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!(obj instanceof Ingredient))
	    return false;
	Ingredient other = (Ingredient) obj;
	return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
	return "Ingredient [id=" + id + ", ingredient=" + ingredient + ", recipes=" + recipes + "]";
    }

}
