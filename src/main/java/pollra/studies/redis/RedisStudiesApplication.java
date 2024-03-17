package pollra.studies.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories(
	basePackages = "pollra.studies.redis.repository"
)
@EnableCaching
@AutoConfiguration
@SpringBootApplication
public class RedisStudiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisStudiesApplication.class, args);
	}

}
