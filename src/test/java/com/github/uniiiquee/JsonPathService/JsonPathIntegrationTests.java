package com.github.uniiiquee.JsonPathService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class JsonPathIntegrationTests {
	
    @Autowired
    private MockMvc mvc;
    
    String inputJson = "            {\r\n" + 
    		"                \"category\": \"reference\",\r\n" + 
    		"                \"author\": \"Test\",\r\n" + 
    		"                \"title\": \"Title\",\r\n" + 
    		"                \"price\": \"9.95\"\r\n" + 
    		"            }";
    
    String inputJsonObjectInObject = "            {\r\n" + 
    		"                \"category\": \"reference\",\r\n" + 
    		"                \"author\": { \"firstName\" : \"Albert\", \"lastName\" : \"Test\"},\r\n" + 
    		"                \"title\": \"Title\",\r\n" + 
    		"                \"price\": \"9.95\"\r\n" + 
    		"            }";
	
	@Test
	void getAuthorTest() throws Exception {
		mvc.perform(post("/jsonPath").param("jsonPathExpression", "$.author")
	            .content(inputJson.getBytes()))
	            .andDo(print())
	            .andExpect(content().string("Test"));
	}
	
	@Test
	void getPrice() throws Exception {
		mvc.perform(post("/jsonPath").param("jsonPathExpression", "$.price")
	            .content(inputJson.getBytes()))
	            .andDo(print())
	            .andExpect(content().string("9.95"));
	}
	
	@Test
	void getObjectInObject() throws Exception {
		mvc.perform(post("/jsonPath").param("jsonPathExpression", "$.author.firstName")
	            .content(inputJsonObjectInObject.getBytes()))
	            .andDo(print())
	            .andExpect(content().string("Albert"));
	}
	

}
