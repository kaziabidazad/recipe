/**
 * 
 */
package com.duke.learn.recipe.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Kazi
 *
 */
public abstract class SimpleEntityManager {

    @PersistenceContext
    protected EntityManager entityManager;

}
