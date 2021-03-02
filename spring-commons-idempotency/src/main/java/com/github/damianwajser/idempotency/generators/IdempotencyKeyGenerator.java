package com.github.damianwajser.idempotency.generators;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;

public interface IdempotencyKeyGenerator {
	String generateKey(HttpHeaders headers, HttpMethod method, String path, HttpServletRequest request);
}
