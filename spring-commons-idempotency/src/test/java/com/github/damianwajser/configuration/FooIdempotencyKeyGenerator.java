package com.github.damianwajser.configuration;

import com.github.damianwajser.idempotency.exception.ArgumentNotFoundException;
import com.github.damianwajser.idempotency.generators.IdempotencyKeyGenerator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class FooIdempotencyKeyGenerator implements IdempotencyKeyGenerator {

	private static final String IDEMPOTENCY_DEFAULT_HEADER = "X-Idempotency-Key";

	@Override
	public String generateKey(HttpHeaders headers, HttpMethod method, String path, HttpServletRequest request) {
		String key = getHeaderValue(headers, IDEMPOTENCY_DEFAULT_HEADER);
		return path + "::" + key + "::" + method.toString();
	}

	protected String getHeaderValue(HttpHeaders headers, String headerKey) {
		List<String> idempotencyHeader = headers.get(headerKey);
		String key;
		if (idempotencyHeader != null) {
			key = idempotencyHeader.stream().collect(Collectors.joining("-"));
		} else {
			throw new ArgumentNotFoundException(headerKey);
		}
		return key;
	}
}
