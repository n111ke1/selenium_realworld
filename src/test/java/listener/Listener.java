package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.time.Duration;

public class Listener implements ITestListener {
//    long startTime = System.currentTimeMillis();
//    long endTime = System.currentTimeMillis();


    @Override
    public void onTestStart(ITestResult result) {
//        ITestNGMethod method = result.getMethod();
//        System.out.println("Start " + method.getMethodName() + " test");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long durationTime = result.getEndMillis() - result.getStartMillis();
        System.out.print("Execution time: " + Duration.ofMillis(durationTime).getSeconds() + "sec ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        long durationTime = result.getEndMillis() - result.getStartMillis();
        System.out.print("Execution time: " + Duration.ofMillis(durationTime).getSeconds() + "sec ");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }


    @Override
    public void onFinish(ITestContext context) {
        for (ITestNGMethod allTestMethod : context.getAllTestMethods()) {
            System.out.println(" ===>> test name: " + allTestMethod.getMethodName());
        }

    }
}

