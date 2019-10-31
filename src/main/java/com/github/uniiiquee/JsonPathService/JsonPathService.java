package com.github.uniiiquee.JsonPathService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;

@Service
public class JsonPathService {

	/**
	 * Evaluates a json path expression on a json object. Only accepts definite
	 * expressions which have single response. See
	 * {@link JsonPathService#isDefinte(String).
	 * 
	 * @param expression the expression which is applied.
	 * @param json       the input json object.
	 * @return the result of the evaluation.
	 */
	public String evaluteDefiniteJsonPath(String expression, String json) {
		if (!isDefinte(expression)) {
			throw new IllegalArgumentException("the path must be definite");
		}
		String result = JsonPath.read(json, expression);
		return result;
	}

	/**
	 * Evaluates a json path expression on a json object. Only accepts indefinite
	 * expressions which have multiple responses. See
	 * {@link JsonPathService#isDefinte(String).
	 * 
	 * @param expression the expression which is applied.
	 * @param json       the input json object.
	 * @return the result of the evaluation.
	 */
	public List<String> evaluteIndefiniteJsonPath(String expression, String json) {
		if (isDefinte(expression)) {
			throw new IllegalArgumentException("the path must be indefinite");
		}
		List<String> result = JsonPath.read(json, expression);
		return result;
	}

	/**
	 * Determines if ja expression is definite or indefinite. It is indefinite if it
	 * contains for example "..". For a full list see {@link JsonPath#isDefinite()}
	 * 
	 * @param expression
	 * @return {@code true} if the expression is definite.
	 */
	public boolean isDefinte(String expression) {
		return JsonPath.isPathDefinite(expression);
	}

}
