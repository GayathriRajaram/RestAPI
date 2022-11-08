package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
	"json:target/cucumber-reports/cucumber.json" }, 
			features={"src/test/resources/Getfeatures.feature"},
			glue={"com.StepDefinition"},
			dryRun = false,
			monochrome = true
			)
	

public class Runner_GetMethod extends AbstractTestNGCucumberTests{

}
