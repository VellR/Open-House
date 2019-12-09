package com.platform.open_house.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/platform/open_house/feature",
		glue = "com/platform/open_house/step_definitions")
public class OpenHouseRunner {}
