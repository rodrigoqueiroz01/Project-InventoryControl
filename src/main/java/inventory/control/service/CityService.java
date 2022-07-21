package inventory.control.service;

import inventory.control.model.CityModel;
import inventory.control.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CityService {

    private static final String INVALIDATION_MESSAGE = "Cidade inválida.";

    private final CityRepository cityRepository;

    public CityModel save(CityModel cityModel) {
        return cityRepository.save(cityModel);
    }

    public CityModel findById(UUID uuid) {
        return cityRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
    }

    public List<CityModel> findAll() {
        return cityRepository.findAll();
    }

    public CityModel update(CityModel cityModel, UUID uuid) {
        cityRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        cityModel.setCodCity(uuid);
        cityRepository.save(cityModel);
        return cityModel;
    }

    public UUID delete(UUID uuid) {
        var city = cityRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        cityRepository.delete(city);
        return uuid;
    }

}
