package com.cba.worksubmission;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple WorkItemSubmission.
 */
public class WorkItemSubmissionTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public WorkItemSubmissionTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(WorkItemSubmissionTest.class);
	}

	/**
	 * Test to submit 100 work items using 8 threads.
	 */
	public void testWorkItemSubmission() {
		int parallelism = 8;

		WorkItemExecutor executor = new WorkItemExecutorImpl(parallelism);
		
		// Check queue, threads, tasks in executor before submission
		checkBeforeSubmission(executor);

		// Submit work items
		WorkItem wi;
		Set<WorkItemSubmissionResult> results = new HashSet<WorkItemSubmissionResult>();
		WorkItemSubmissionResult result;

		for (int i = 0; i < 100; i++) {
			wi = new WorkItemImpl("WorkItem_" + i);
			result = executor.executeWorkItem(wi, parallelism);
			
			if (i == 4) {
				// Check queue, threads, tasks in executor in the middle of submission
				// pool size should be less than 8
				checkMiddleSubmission(executor, parallelism, i);
			}
			if (i == 10) {
				// Check queue, threads, tasks in executor in the middle of submission
				// pool size should be 8
				checkMiddleSubmission(executor, parallelism, i);
			}

			if (result != null) {
				results.add(result);
			}
		}
		
		// Check queue, threads, tasks in executor after submission
		checkAfterSubmission(executor, parallelism, 100);
		
		// shutdown the executor
		executor.shutdown();
	}
	
	private void checkBeforeSubmission(WorkItemExecutor wiExecutor) {
		WorkItemExecutorImpl executor = (WorkItemExecutorImpl) wiExecutor;
		// Check queue in the executor before submission
		BlockingQueue<Runnable> queue = executor.getQueue();
		assertNotNull(queue);
		assertTrue("Queue size before submission should be 0, but got " + queue.size(), queue.size() == 0);
		
		// Check number of active threads before submission
		int activeThreads = executor.getActiveCount();
		assertTrue("Number of active threads - before: " + activeThreads, activeThreads == 0);
		
		// Check number of completed tasks before submission
		long completedTaskCount = executor.getCompletedTaskCount();
		assertTrue("Number of completed tasks - before: " + completedTaskCount, completedTaskCount == 0);
		
		// Check number of task count before submission
		long taskCount = executor.getTaskCount();
		assertTrue("Number of tasks - before: " + taskCount, taskCount == 0);

		// Check the largest pool size before submission
		int largestPoolSize = executor.getLargestPoolSize();
		assertTrue("Largest pool size - before: " + largestPoolSize, largestPoolSize == 0);
		
		// Check the current pool size before submission
		int poolSize = executor.getPoolSize();
		assertTrue("Pool size - before: " + poolSize, poolSize == 0);
	}
	
	private void checkMiddleSubmission(WorkItemExecutor wiExecutor, int parallelism, int taskNumber) {
		WorkItemExecutorImpl executor = (WorkItemExecutorImpl) wiExecutor;
		// Check queue in the executor before submission
		BlockingQueue<Runnable> queue = executor.getQueue();
		assertNotNull(queue);
		assertTrue("Queue size middle submission should be 0, but got " + queue.size(), queue.size() == 0);
		
		// Check number of active threads before submission
		int activeThreads = executor.getActiveCount();
		assertTrue("Number of active threads - middle: " + activeThreads, activeThreads == 0);
		
		// Check number of completed tasks before submission
		long completedTaskCount = executor.getCompletedTaskCount();
		assertTrue("Number of completed tasks - middle: " + completedTaskCount, completedTaskCount == (taskNumber + 1));
		
		// Check number of task count before submission
		long taskCount = executor.getTaskCount();
		assertTrue("Number of tasks - middle: " + taskCount, taskCount == (taskNumber + 1));

		// Check the largest pool size before submission
		int largestPoolSize = executor.getLargestPoolSize();
		assertTrue("Largest pool size - middle: " + largestPoolSize, largestPoolSize > 0);
		
		// Check the current pool size before submission
		int poolSize = executor.getPoolSize();
		assertTrue("Pool size - middle: " + poolSize, poolSize > 0);
		assertTrue("Pool size - middle: " + poolSize, 
				(taskNumber > parallelism ? (poolSize == parallelism) : (poolSize == (taskNumber + 1))));
	}
	
	private void checkAfterSubmission(WorkItemExecutor wiExecutor, int parallelism, int numOfTasks) {
		WorkItemExecutorImpl executor = (WorkItemExecutorImpl) wiExecutor;
		// Check queue in the executor before submission
		BlockingQueue<Runnable> queue = executor.getQueue();
		assertNotNull(queue);
		assertTrue("Queue size after submission should be 0, but got " + queue.size(), queue.size() == 0);
		
		// Check number of active threads before submission
		int activeThreads = executor.getActiveCount();
		assertTrue("Number of active threads - after: " + activeThreads, activeThreads == 0);
		
		// Check number of completed tasks before submission
		long completedTaskCount = executor.getCompletedTaskCount();
		assertTrue("Number of completed tasks - after: " + completedTaskCount, completedTaskCount == numOfTasks);
		
		// Check number of task count before submission
		long taskCount = executor.getTaskCount();
		assertTrue("Number of tasks - after: " + taskCount, taskCount == numOfTasks);

		// Check the largest pool size before submission
		int largestPoolSize = executor.getLargestPoolSize();
		assertTrue("Largest pool size - after: " + largestPoolSize, 
				(numOfTasks > parallelism ? (largestPoolSize == parallelism) : (largestPoolSize == numOfTasks)));
		
		// Check the current pool size before submission
		int poolSize = executor.getPoolSize();
		assertTrue("Pool size - after: " + poolSize, 
				(numOfTasks > parallelism ? (poolSize == parallelism) : (poolSize == numOfTasks)));

	}
}
