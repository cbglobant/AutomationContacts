package com.globant.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static java.lang.String.format;

public class TestNGListener extends TestListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestNGListener.class);

    @Override
    public void onTestStart(ITestResult tr) {
        LOGGER.info(format("Test Started.... [%s]", tr.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        LOGGER.info(format("Test [%s] PASSED", tr.getName()));
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        LOGGER.info(format("Test [%s] FAILED", tr.getName()));
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        LOGGER.info(format("Test [%s] SKIPPED", tr.getName()));
    }
}
