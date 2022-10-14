/**
 * 
 */
package com.duke.learn.recipe.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Kazi
 *
 */
@SpringBootApplication(scanBasePackages  = "com.duke.learn.recipe")
public class RecipeApp {

    public static void main(String[] args) {
	SpringApplication.run(RecipeApp.class, args);
    }

}
