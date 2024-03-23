package practise.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM mail_forwarding_user WHERE email = :email")
    User findByEmail(@Param("email")String email);

}
