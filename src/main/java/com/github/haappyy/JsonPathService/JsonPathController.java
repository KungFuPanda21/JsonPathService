package com.github.haappyy.JsonPathService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class JsonPathController {
	
	
	/**
	 * Evaluates the JSON path expression provided via the jsonPathExpression parameter.
	 * @param jsonPathExpression the expression which is applied to the provided json.
	 * @param json the input json object.
	 * @return the result of the json path evaluation.
	 */
	@ResponseBody
	@RequestMapping(value = "/jsonPath", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> evaluteJsonPath(@RequestParam(name = "jsonPathExpression") String jsonPathExpression, @RequestBody String json) {
		return ResponseEntity.status(501).build();
	}
}
