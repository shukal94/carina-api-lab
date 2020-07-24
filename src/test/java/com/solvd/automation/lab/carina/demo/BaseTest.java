package com.solvd.automation.lab.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest extends AbstractTest {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void aaa() {
        LOGGER.info("\nBefore Test\n");
    }

    @AfterTest
    public void bbb() {
        LOGGER.info("\nAfter Test\n");
    }
}
