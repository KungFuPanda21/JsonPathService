package com.github.haappyy.JsonPathService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class JsonPathController {
	
	@ResponseBody
	@RequestMapping(value = "/jsonPath", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> evaluteJsonPath(@RequestParam(name = "jsonPathExpression") String jsonPathExpression) {
		return ResponseEntity.status(501).build();
	}
}
