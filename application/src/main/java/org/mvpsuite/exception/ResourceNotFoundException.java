package org.mvpsuite.exception;

import org.mvpsuite.problem.member.Detail;
import org.mvpsuite.problem.member.Status;
import org.mvpsuite.problem.member.Title;
import org.springframework.http.HttpStatus;

@Status(HttpStatus.NOT_FOUND)
@Detail("Resource not found")
@Title("Not Found")
public class ResourceNotFoundException extends RuntimeException {}
