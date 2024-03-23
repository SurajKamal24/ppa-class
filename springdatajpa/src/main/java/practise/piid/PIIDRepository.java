package practise.piid;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PIIDRepository extends CrudRepository<PIID, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM mail_forwarding_piid WHERE value = :value")
    PIID findByValue(@Param("value")String value);

}
