package com.meetsky.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/meetsky/step_definitions",
        //dryRun = true,
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "junit:target/cucumber-report.xml",
                "rerun:target/rerun.txt"
        },
        tags = "@MTSK-487"      // This must be assigned with Test Execution ticket number from JIRA in order to run all scenarios
        // and get their "cucumber.json" report to export to the JIRA at the end.
)

public class CukesRunner {
}