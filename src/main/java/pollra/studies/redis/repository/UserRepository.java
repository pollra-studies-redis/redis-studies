package pollra.studies.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pollra.studies.redis.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
