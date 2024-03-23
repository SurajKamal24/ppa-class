package practise.role;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM mail_forwarding_role WHERE name = :name")
    Role findByName(@Param("name")String name);

}
