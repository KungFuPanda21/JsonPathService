package com.github.uniiiquee.JsonPathService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JsonPathServiceApplicationTests {

	@Autowired JsonPathService jsonPathService;
	
	@Test
	void isDefinite() {
		assertTrue(jsonPathService.isDefinte("$.store.book"));
	}
	
	@Test
	void isIndefinite() {
		assertFalse(jsonPathService.isDefinte("$..store.book"));
	}
	
	@Test
	void isGetAuthor() {
		String json = "            {\r\n" + 
				"                \"category\": \"reference\",\r\n" + 
				"                \"author\": \"Test\",\r\n" + 
				"                \"title\": \"fghfhgfh\",\r\n" + 
				"                \"price\": 7.95\r\n" + 
				"            }";
		assertEquals("Test", jsonPathService.evaluteDefiniteJsonPath("$.author", json));
	}

}
