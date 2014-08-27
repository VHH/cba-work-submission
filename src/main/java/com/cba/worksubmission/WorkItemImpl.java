/**
 * 
 */
package com.cba.worksubmission;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An implementation of a {@code WorkItem} to be submitted to {@code WorkItemExecutor} for execution.
 * 
 * @author Van Hai Ho
 *
 */
public class WorkItemImpl implements WorkItem {

	/** For logging */
	private final static Logger log = Logger.getLogger(WorkItemImpl.class
			.getName());
	
	/** The name of the work item */
	private String name;
	
	public WorkItemImpl(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public WorkItemSubmissionResult call() throws Exception {
		long now = System.currentTimeMillis();
		log.log(Level.INFO, "WorkItem called on " + name + " at " + now);
		WorkItemCompletionCallback callback = new WorkItemCompletionCallbackImpl();
		execute(callback);
		return new WorkItemSubmissionResultImpl(name);
	}

	/* (non-Javadoc)
	 * @see com.cba.worksubmission.WorkItem#execute(com.cba.worksubmission.WorkItemCompletionCallback)
	 */
	public void execute(WorkItemCompletionCallback callback) {
		long now = System.currentTimeMillis();
		log.log(Level.INFO, "WorkItem executed on " + name + " at " + now);
		callback.setWorkItem(name);
		callback.complete();
	}

	/**
	 * Returns the name of the WorkItem.
	 * 
	 * @return the name of the WorkItem.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the WorkItem.
	 * 
	 * @param name the name of the WorkItem.
	 */
	public void setName(String name) {
		this.name = name;
	}

	
}
