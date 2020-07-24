/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.solvd.automation.lab.carina.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.automation.lab.carina.demo.api.DeleteUserMethod;
import com.solvd.automation.lab.carina.demo.api.GetUserMethods;
import com.solvd.automation.lab.carina.demo.api.PostUserMethod;
import com.solvd.automation.lab.carina.demo.api.azure.PostAzureUserMethod;
import com.solvd.automation.lab.carina.demo.bo.AzureUser;
import org.apache.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTestV2 extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(APISampleTestV2.class);

    @BeforeClass
    public void fff() {
        LOGGER.info("\nBefore class\n");
    }

    @AfterClass
    public void eee() {
        LOGGER.info("\nAfter class\n");
    }

    @BeforeMethod
    public void ccc() {
        LOGGER.info("\nBefore Method\n");
    }

    @AfterMethod
    public void ddd() {
        LOGGER.info("\nAfter Method\n");
    }

    @MethodOwner(owner = "sshukalovich")
    @Test
    public void testCreateAzureUser() throws Exception{
        String uname = "sshukalovich";
        String pword = "root";
        PostAzureUserMethod postAzureUserMethod = new PostAzureUserMethod(uname, pword);
        postAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureUserMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureUser actualUser = mapper.readValue(rs, AzureUser.class);

        Assert.assertNotNull(actualUser, "Response object cannot be null!");
        Assert.assertEquals(actualUser.getUsername(), uname, "Username is not as expected!");
        Assert.assertEquals(actualUser.getPassword(), pword, "Password is not as expected!");

    }

}
