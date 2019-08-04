package jamesreed.holidayextrasapitask.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserDAO extends CrudRepository<User, Long> {
}
