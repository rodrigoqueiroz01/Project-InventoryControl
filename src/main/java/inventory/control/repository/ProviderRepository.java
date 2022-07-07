package inventory.control.repository;

import inventory.control.model.ProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderModel, UUID> { }
