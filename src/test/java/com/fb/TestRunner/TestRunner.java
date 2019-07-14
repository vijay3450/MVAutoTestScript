package com.fb.TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "classpath:features"
		 ,glue={"classpath:com.fb.stepDef"},
		 format = {"pretty", "html:target/Destination"} 
		 )
public class TestRunner {

	
	
}
