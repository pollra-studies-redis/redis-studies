package pollra.studies.redis.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@RedisHash("users")
public class User {

	@Id
	private String id;

	@Indexed
	private String email;

	private String name;

	private int age;
}
