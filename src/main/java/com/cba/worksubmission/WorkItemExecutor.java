/**
 * 
 */
package com.cba.worksubmission;

import java.util.concurrent.ExecutorService;

/**
 * An Executor that provides methods to manage the threads executing the work item.
 * 
 * @author Van Hai Ho
 *
 */
public interface WorkItemExecutor extends ExecutorService {

	/** 
	 * Executes the specified <code>WorkItem</code> using a number of threads 
	 * as specified in <code>parallelism</code>.
	 * 
	 * @param w The WorkItem to be executed.
	 * @param parallelism The number of threads to be used for execution.
	 * @return The result of work item submission.
	 */
	public WorkItemSubmissionResult executeWorkItem(WorkItem w, int parallelism);
	
}
