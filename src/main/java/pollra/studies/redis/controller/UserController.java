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
import pollra.studies.redis.domain.UserMapper;
import pollra.studies.redis.repository.UserRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserRepository userRepository;

	@PostMapping
	public String create(@RequestBody UserCreate.Request userCreate) {
		User saveTarget = UserMapper.toEntity(userCreate);
		return userRepository.save(saveTarget).getId();
	}

	@Cacheable(value = "users", key = "#id")
	@GetMapping("/{id}")
	public UserCreate.Response get(@PathVariable String id) {
		User user = userRepository.findById(id).orElseThrow();
		return UserMapper.toResponse(user);
	}
}
