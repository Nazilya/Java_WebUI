package com.geekbrains.lesson8;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/lesson8"},
        plugin = {"pretty", "html:target/cucumber/report.html"})
public class RunCucumberTests {
}