package pollra.studies.redis.domain;

import pollra.studies.redis.controller.UserCreate;

public class UserMapper {
	public static User toEntity(UserCreate.Request request) {
		return User.builder()
				.email(request.email())
				.name(request.name())
				.age(request.age())
				.build();
	}

	public static UserCreate.Response toResponse(User user) {
		return new UserCreate.Response(
				user.getId(),
				user.getEmail(),
				user.getName(),
				user.getAge()
		);
	}
}
