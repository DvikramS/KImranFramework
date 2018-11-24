package Listener;

import java.io.File;
import java.util.List;
import java.util.Set;

import Base.BasePage;
import Util.*;

import org.testng.IClass;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

public class TestsListenerAdapter implements IInvokedMethodListener {

	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		/*String fileName = System.getProperty("user.dir") + File.separator
				+ "ErrorScreenshots" + File.separator + "filename.jpg";
		*/	
		if (method.isTestMethod()) {
			List<Throwable> verificationFailures = ErrorUtility
					.getVerificationFailures();
			// if there are verification failures...
			if (verificationFailures.size() != 0) {
				// set the test to failed
				result.setStatus(ITestResult.FAILURE);

				// if there is an assertion failure add it to
				// verificationFailures
				if (result.getThrowable() != null) {
					verificationFailures.add(result.getThrowable());
				}

				int size = verificationFailures.size();
				// if there's only one failure just set that
				if (size == 1) {
					result.setThrowable(verificationFailures.get(0));
				} else {
					// create a failure message with all failures and stack
					// traces (except last failure)
					StringBuffer failureMessage = new StringBuffer(
							"Multiple failures (").append(size).append("):nn");
					for (int i = 0; i < size - 1; i++) {
						failureMessage.append("Failure ").append(i + 1)
								.append(" of ").append(size).append(":n");
						Throwable t = verificationFailures.get(i);
						String fullStackTrace = Utils.stackTrace(t, false)[1];
						failureMessage.append(fullStackTrace).append("nn");
					}

					// final failure
					Throwable last = verificationFailures.get(size - 1);
					failureMessage.append("Failure ").append(size)
							.append(" of ").append(size).append(":n");
					failureMessage.append(last.toString());

					// set merged throwable
					Throwable merged = new Throwable(failureMessage.toString());
					merged.setStackTrace(last.getStackTrace());

					result.setThrowable(merged);

				}
			}

		}

	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
	}

	/*
	 * public void onTestFailure(ITestResult result) { String fileName =
	 * System.getProperty("user.dir") + File.separator + "ErrorScreenshots" +
	 * File.separator + "filename.jpg"; Reporter.log("<a href=\"" + fileName +
	 * "\">  Clickhere  </a>"); Reporter.setCurrentTestResult(null);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Override public Object getAttribute(String name) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void setAttribute(String name, Object value) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public Set<String> getAttributeNames() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Object removeAttribute(String name) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public int compareTo(ITestResult arg0) { // TODO Auto-generated
	 * method stub return 0; }
	 * 
	 * @Override public int getStatus() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * @Override public void setStatus(int status) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public ITestNGMethod getMethod() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Object[] getParameters() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public void setParameters(Object[] parameters) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public IClass getTestClass() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public Throwable getThrowable() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public void setThrowable(Throwable throwable) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public long getStartMillis() { // TODO Auto-generated method
	 * stub return 0; }
	 * 
	 * @Override public long getEndMillis() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * @Override public void setEndMillis(long millis) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public String getName() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public boolean isSuccess() { // TODO Auto-generated method stub
	 * return false; }
	 * 
	 * @Override public String getHost() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public Object getInstance() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public String getTestName() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public String getInstanceName() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public ITestContext getTestContext() { // TODO Auto-generated
	 * method stub return null; }
	 */

}
