package com.github.uniiiquee.JsonPathService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;

@Service
public class JsonPathService {

	public String evaluteDefiniteJsonPath(String expression, String json) {
		if (!isDefinte(expression)) {
			throw new IllegalArgumentException("the path must be definite");
		}
		String result = JsonPath.read(json, expression);
		return result;
	}

	public List<String> evaluteIndefiniteJsonPath(String expression, String json) {
		if (isDefinte(expression)) {
			throw new IllegalArgumentException("the path must be indefinite");
		}
		List<String> result = JsonPath.read(json, expression);
		return result;
	}

	public boolean isDefinte(String expression) {
		return JsonPath.isPathDefinite(expression);
	}

}
