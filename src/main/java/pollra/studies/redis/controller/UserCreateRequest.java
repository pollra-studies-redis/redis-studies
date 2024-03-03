package pollra.studies.redis.controller;

public record UserCreateRequest(
	String email,
	String name,
	Integer age
) { }
