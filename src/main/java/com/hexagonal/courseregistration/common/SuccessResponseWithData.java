package com.hexagonal.courseregistration.common;

record SuccessResponseWithData(
  String message,
  Object data
) {
}
