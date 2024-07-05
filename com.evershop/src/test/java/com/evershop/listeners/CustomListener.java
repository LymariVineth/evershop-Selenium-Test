package com.evershop.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.evershop.utils.Log;

public class CustomListener implements ITestListener, ISuiteListener {
	@Override
	public void onTestStart(ITestResult result) {
		Log.info("------------------------------------------------------------------------------------------------------- ");
		Log.info("El caso de prueba " + result.getName() + " esta comenzando ...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("..................PASADO.................." );
		Log.info("------------------------------------------------------------------------------------------------------- ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("..................FALLADO.................." );
		Log.info("------------------------------------------------------------------------------------------------------- ");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.info("..................SALTADO.................." );
		Log.info("------------------------------------------------------------------------------------------------------- ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ISuite suite) {
		Log.info("Comienza " + suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		Log.info("Finaliza " + suite.getName());
	}

}
