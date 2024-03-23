package practise.access;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import practise.access.Access.AccessId;

@Repository
public interface AccessRepository extends CrudRepository<Access, AccessId> {
}
