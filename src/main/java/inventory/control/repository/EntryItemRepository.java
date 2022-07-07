package inventory.control.repository;

import inventory.control.model.EntryItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EntryItemRepository extends JpaRepository<EntryItemModel, UUID> { }
