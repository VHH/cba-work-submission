package com.cba.worksubmission;

/**
 * An implementation of {@code WorkItemSubmissionResult} to provide status and message of WorkItem submission.
 * 
 * @author Van Hai Ho
 *
 */
public class WorkItemSubmissionResultImpl implements WorkItemSubmissionResult {

	/**
	 * Serial version number for this class. 
	 */
	private static final long serialVersionUID = -7752149869924656363L;
	
	private String workItem;
	private String resultMessage;
	private int resultStatus = -1;
	
	/**
	 * Constructor for the result of WorkItemSubmission.
	 */
	public WorkItemSubmissionResultImpl() {
	}
	
	/**
	 * Constructor for the result of WorkItemSubmission.
	 * 
	 * @param workItem The work item to be submitted.
	 */
	public WorkItemSubmissionResultImpl(String workItem) {
		this.workItem = workItem;
	}
	
	/**
	 * Constructor for the result of WorkItemSubmission.
	 * 
	 * @param workItem The work item to be submitted.
	 * @param message The result message for the submission.
	 * @param status The status for the submission.
	 */
	public WorkItemSubmissionResultImpl(String workItem, String message, int status) {
		this.workItem = workItem;
		this.resultMessage = message;
		this.resultStatus = status;
	}
	
	/**
	 * Returns the name of the WorkItem submitted.
	 * 
	 * @return the name of the WorkItem submitted.
	 */
	public String getWorkItem() {
		return workItem;
	}

	/**
	 * Sets the name of the WorkItem submitted.
	 * 
	 * @param workItem the name of the WorkItem submitted.
	 */
	public void setWorkItem(String workItem) {
		this.workItem = workItem;
	}

	/** 
	 * Returns the submission result message.
	 * 
	 * @return The submission result message.
	 */
	public String getResultMessage() {
		return resultMessage;
	}
	
	/** 
	 * Sets the submission result message.
	 * 
	 * @param message The submission result message.
	 */
	public void setResultMessage(String message) {
		this.resultMessage = message;
	}
	
	/** 
	 * Returns the submission result status, whether success or fail.
	 * 
	 * @return The submission result status.
	 */
	public int getResultStatus() {
		return resultStatus;
	}
	
	/** 
	 * Sets the submission result status.
	 * 
	 * @param status The submission result status.
	 */
	public void setResultStatus(int status) {
		this.resultStatus = status;
	}
	
	/** 
	 * For debugging purposes.
	 * 
	 * @return The text representing this.
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		return buf.toString();
	}

}
