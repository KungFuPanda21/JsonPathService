package com.github.uniiiquee.JsonPathService;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	private final static Logger LOGGER = Logger.getLogger(JsonPathController.class.getName());
	
	@Autowired JsonPathService jsonPathService;

	/**
	 * Evaluates the JSON path expression provided via the jsonPathExpression
	 * parameter.
	 * 
	 * @param jsonPathExpression the expression which is applied to the provided
	 *                           json.
	 * @param json               the input json object.
	 * @return the result of the json path evaluation.
	 */
	@ResponseBody
	@RequestMapping(value = "/jsonPath", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> evaluteJsonPath(@RequestParam(name = "jsonPathExpression") String jsonPathExpression,
			@RequestBody String json) {
		LOGGER.log(Level.INFO,
				"Request to jsonPath with the json path expression:" + jsonPathExpression + " and the body:" + json);
		return ResponseEntity.ok(jsonPathService.evaluteDefiniteJsonPath(jsonPathExpression, json));
	}
}
