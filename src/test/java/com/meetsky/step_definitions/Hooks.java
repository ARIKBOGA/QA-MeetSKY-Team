package com.meetsky.step_definitions;

import com.google.common.io.Files;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private static int id = 1;

    @Before
    public void setDriver() {
        Driver.getDriver();
    }

    @After
    public void tearDownScenario() {
        Driver.closeDriver();
    }


    @AfterStep
    public void afterSteps(Scenario scenario) throws IOException {
        //if (scenario.isFailed()) {
        BrowserUtils.waitFor(1);
        File camera = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        Files.move(camera, new File("screenshots/" + id + "_" + scenario.getName() + ".png"));
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", (id++) + scenario.getName());
    }
}