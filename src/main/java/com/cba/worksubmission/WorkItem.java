/**
 * 
 */
package com.cba.worksubmission;

import java.util.concurrent.Callable;

/**
 * {@code WorkItem} to be submitted to {@code WorkItemExecutor} for execution.
 * 
 * @author Van Hai Ho 
 *
 */
public interface WorkItem extends Callable<WorkItemSubmissionResult> {

	/**
	 * Executes submission for this WorkItem.
	 * 
	 * @param callback The callback this executes.
	 */
	public void execute(WorkItemCompletionCallback callback);
}
