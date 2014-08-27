package com.cba.worksubmission;

import java.io.Serializable;

/**
 * The interface for receiving the submission result.
 * 
 * @author Van Hai Ho
 *
 */
public interface WorkItemSubmissionResult extends Serializable {

	/** The status indicates the submission is successful */
	public static final int SUBMISSION_SUCCESS = 1;
	/** The status indicates the submission is failed */
	public static final int SUBMISSION_FAIL = 0;
	
	/** 
	 * Returns the submission result message.
	 * 
	 * @return The submission result message.
	 */
	public String getResultMessage();
	
	/** 
	 * Sets the submission result message.
	 * 
	 * @param message The submission result message.
	 */
	public void setResultMessage(String message);
	
	/** 
	 * Returns the submission result status, whether success or fail.
	 * 
	 * @return The submission result status.
	 */
	public int getResultStatus();
	
	/** 
	 * Sets the submission result status.
	 * 
	 * @param status The submission result status.
	 */
	public void setResultStatus(int status);
	
}
