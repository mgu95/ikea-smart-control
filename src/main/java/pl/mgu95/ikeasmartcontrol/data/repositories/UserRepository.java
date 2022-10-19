package pl.mgu95.ikeasmartcontrol.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mgu95.ikeasmartcontrol.data.model.Client;

public interface UserRepository extends CrudRepository<Client, Long> {
}
