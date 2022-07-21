package inventory.control.repository;

import inventory.control.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface StoreRepository extends JpaRepository<StoreModel, UUID>, JpaSpecificationExecutor {
}
