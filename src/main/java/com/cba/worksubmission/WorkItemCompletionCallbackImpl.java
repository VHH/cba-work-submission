/**
 * 
 */
package com.cba.worksubmission;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An implementation for a callback to consume result after {@code WorkItem} submission completed.
 * 
 * @author Van Hai Ho
 *
 */
public class WorkItemCompletionCallbackImpl implements
		WorkItemCompletionCallback {

	/** For logging */
	private final static Logger log = Logger.getLogger(WorkItemCompletionCallbackImpl.class
			.getName());

	private String workItem;
	
	/**
	 * Returns the work item used in this callback.
	 * 
	 * @return the work item used in this callback.
	 */
	public String getWorkItem() {
		return workItem;
	}

	/**
	 * Sets the work item used in this callback.
	 * 
	 * @param workItem the work item used in this callback.
	 */
	public void setWorkItem(String workItem) {
		this.workItem = workItem;
	}

	/* (non-Javadoc)
	 * @see com.cba.worksubmission.WorkItemCompletionCallback#complete()
	 */
	public void complete() {
		long now = System.currentTimeMillis();
		String completionMessage = "Submission Completed Successfully for " + workItem + " at " + now;
		log.log(Level.INFO, completionMessage);
	}

}
