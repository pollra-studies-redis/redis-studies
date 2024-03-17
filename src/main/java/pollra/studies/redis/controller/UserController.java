package pollra.studies.redis.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pollra.studies.redis.domain.User;
import pollra.studies.redis.repository.UserRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserRepository userRepository;

	@PostMapping
	public String create(
			@RequestBody UserCreateRequest userCreateRequest
	) {
		User save = userRepository.save(
			User.builder()
				.email(userCreateRequest.email())
				.name(userCreateRequest.name())
				.age(userCreateRequest.age())
				.build()
		);
		return save.getId();
	}

	@Cacheable(value = "users", key = "#id")
	@GetMapping("/{id}")
	public User get(@PathVariable String id) {
		return userRepository.findById(id).orElseThrow();
	}
}
