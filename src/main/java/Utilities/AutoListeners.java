package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class AutoListeners implements ITestListener {
    public void onStart(ITestContext execution){
        System.out.println("-----Starting Execution-----");
    }

    public void onFinish(ITestContext execution){
        System.out.println("-----Ending Execution-----");
    }

    public void onTestStart(ITestResult test){
        System.out.println("---- Test "  + test.getName() + " start ---");
    }


    public void onTestSuccess(ITestResult test){
        System.out.println("---- Test "  + test.getName() + " pass ---");

        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File("./test-recordings/" + test.getName() + ".avi");
        if(file.delete()){
            System.out.println("file deleted");
        }
        else System.out.println("failed to delete");


    }


    public void onTestFailure(ITestResult test){

        System.out.println("---- Test "  + test.getName() + " fail ---");

        CommonOps.saveScreenshot();
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test){
        // TODO Auto-generated method stub
    }
}
