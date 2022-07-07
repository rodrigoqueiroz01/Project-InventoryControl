package inventory.control.repository;

import inventory.control.model.ProhibitedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProhibitedRepository extends JpaRepository<ProhibitedModel, UUID> { }
