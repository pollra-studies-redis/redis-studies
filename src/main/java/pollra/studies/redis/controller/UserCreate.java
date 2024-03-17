package pollra.studies.redis.controller;

public class UserCreate {
	public record Request(
		String email,
		String name,
		Integer age
	) { }

	public record Response(
		String id,
		String email,
		String name,
		Integer age
	) { }
}
