package com.cba.worksubmission;

/**
 * A callback to consume result after {@code WorkItem} submission completed.
 * 
 * @author Van Hai Ho
 *
 */
public interface WorkItemCompletionCallback {

	/**
	 * Processes result upon WorkItem submission completion.
	 */
	public void complete();

	/**
	 * Returns the work item used in this callback.
	 * 
	 * @return the work item used in this callback.
	 */
	public String getWorkItem();

	/**
	 * Sets the work item used in this callback.
	 * 
	 * @param workItem the work item used in this callback.
	 */
	public void setWorkItem(String workItem);
	
}
