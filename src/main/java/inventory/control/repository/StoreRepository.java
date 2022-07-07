package inventory.control.repository;

import inventory.control.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StoreRepository extends JpaRepository<StoreModel, UUID> { }
