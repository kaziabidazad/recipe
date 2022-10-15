/**
 * 
 */
package com.duke.learn.recipe.dto;

import com.duke.learn.recipe.util.Status;

/**
 * @author Kazi
 *
 */
public abstract class CommonResponse implements CommonOutput {

    private String message;
    private Status status;

    /**
     * @return the message
     */
    public String getMessage() {
	return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
	this.message = message;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
	return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
	this.status = status;
    }

    @Override
    public String toString() {
	return "CommonResponse [message=" + message + ", status=" + status + "]";
    }

}
