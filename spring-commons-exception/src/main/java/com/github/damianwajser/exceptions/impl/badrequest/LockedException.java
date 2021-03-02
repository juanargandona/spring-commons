package com.github.damianwajser.exceptions.impl.badrequest;

import com.github.damianwajser.exceptions.RestException;
import com.github.damianwajser.exceptions.model.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(code = HttpStatus.LOCKED)
public class LockedException extends RestException {

	private static final long serialVersionUID = 3193388927248995976L;

	public LockedException(ExceptionDetail detail) {
		super(detail);
	}

	public LockedException(List<ExceptionDetail> details) {
		super(details);
	}

	public LockedException(String errorCode, String errorMessage, Optional<Object> errorDetail) {
		super(errorCode, errorMessage, errorDetail);
	}

	public LockedException(ExceptionDetail detail, Exception e) {
		super(detail, e);
	}

	public LockedException(List<ExceptionDetail> details, Exception e) {
		super(details, e);
	}

	public LockedException(String errorCode, String errorMessage, Optional<Object> errorDetail, Exception e) {
		super(errorCode, errorMessage, errorDetail, e);
	}
}
