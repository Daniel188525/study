package com.siebre.mvctest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.siebre.config.AppConfig;
import com.siebre.config.Log4jConfig;
import com.siebre.config.MvcConfig;
import com.siebre.log4j.JUnit4ClassRunner;

//ע����  
@RunWith(JUnit4ClassRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp") //default value = "src/main/webapp"
@ContextHierarchy({
		@ContextConfiguration(name = "parent", classes = AppConfig.class),
		@ContextConfiguration(name = "child", classes = MvcConfig.class),
		@ContextConfiguration(name = "log4j", classes = Log4jConfig.class) })
public class UserControllerWebAppContextSetupTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testView() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/user/1"))
				.andExpect(MockMvcResultMatchers.view().name("user/login.jsp"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("user"))
				.andDo(MockMvcResultHandlers.print()).andReturn();

		Assert.assertNotNull(result.getModelAndView().getModel().get("user"));
	}
}
