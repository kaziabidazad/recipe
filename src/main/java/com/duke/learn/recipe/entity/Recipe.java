/**
 * 
 */
package com.duke.learn.recipe.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Kazi
 *
 */
@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {

    private static final long serialVersionUID = -6046764583480715809L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "vegeterian")
    private boolean vegeterian;

    @Column(name = "serving_size")
    private Integer servingSize;

    @Column(name = "instructions")
    private String instructions;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "recipe_ingredients", joinColumns = { @JoinColumn(name = "recipe_id") }, inverseJoinColumns = {
	    @JoinColumn(name = "ingredient_id") })
    private Set<Ingredient> ingredients;

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
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the vegeterian
     */
    public boolean isVegeterian() {
	return vegeterian;
    }

    /**
     * @param vegeterian the vegeterian to set
     */
    public void setVegeterian(boolean vegeterian) {
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
    public Set<Ingredient> getIngredients() {
	return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(Set<Ingredient> ingredients) {
	this.ingredients = ingredients;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
	return serialVersionUID;
    }

    @Override
    public String toString() {
	return "Recipe [id=" + id + ", name=" + name + ", vegeterian=" + vegeterian + ", servingSize=" + servingSize
		+ ", instructions=" + instructions + ", ingredients=" + ingredients + "]";
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!(obj instanceof Recipe))
	    return false;
	Recipe other = (Recipe) obj;
	return Objects.equals(id, other.id);
    }

}
