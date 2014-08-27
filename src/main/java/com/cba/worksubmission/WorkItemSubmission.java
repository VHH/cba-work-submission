package com.cba.worksubmission;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The main class for running {@code WorkItemSubmission}.
 * 
 * @author Van Hai Ho
 */
public class WorkItemSubmission {

	/** For logging */
	private final static Logger log = Logger.getLogger(WorkItemSubmission.class
			.getName());

	public static void main(String[] args) {
		int parallelism = 4;

		WorkItemExecutor executor = new WorkItemExecutorImpl(parallelism);
		WorkItem wi;
		Set<WorkItemSubmissionResult> results = new HashSet<WorkItemSubmissionResult>();
		WorkItemSubmissionResult result;
		
		for (int i = 0; i < 10; i++) {
			wi = new WorkItemImpl("WorkItem_" + i);
			result = executor.executeWorkItem(wi, parallelism);
			if (result != null) {
				results.add(result);
			}
		}
		executor.shutdown();
		log.log(Level.INFO, "Submission result size = " + results.size());
		log.log(Level.INFO, "Finished all threads");
	}
}
