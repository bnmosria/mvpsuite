package org.mvpsuite.exception;

import org.mvpsuite.problem.member.*;
import org.springframework.http.HttpStatus;

@Status(HttpStatus.CONFLICT)
@Detail("The given user name is already in use. Please select another one")
@Title("Duplicated user name")
public class DuplicatedUserNameException extends RuntimeException {}
