package extentReportPack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class reportEx {
	
	public ExtentReports extent;
	ExtentSparkReporter reporter;
	
	public void report()
	{
	 extent= new ExtentReports();
	 reporter= new ExtentSparkReporter("rep.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD, ViewName.TEST}).apply();
	extent.attachReporter(reporter);
	
	}
	
	



}
