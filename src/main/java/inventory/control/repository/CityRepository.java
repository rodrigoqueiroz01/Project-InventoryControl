package inventory.control.repository;

import inventory.control.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityModel, UUID> { }
