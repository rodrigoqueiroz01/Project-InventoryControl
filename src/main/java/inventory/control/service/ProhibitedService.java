package inventory.control.service;

import inventory.control.model.ProhibitedModel;
import inventory.control.repository.ProhibitedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProhibitedService {

    public static final String INVALIDATION_MESSAGE = "Entrada inválida.";

    private final ProhibitedRepository prohibitedRepository;

    public ProhibitedModel save(ProhibitedModel prohibitedModel) {
        return prohibitedRepository.save(prohibitedModel);
    }

    public ProhibitedModel findById(UUID uuid) {
        return prohibitedRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
    }

    public List<ProhibitedModel> findAll() {
        return prohibitedRepository.findAll();
    }

    public ProhibitedModel update(ProhibitedModel prohibitedModel, UUID uuid) {
        prohibitedRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        prohibitedModel.setCodProhibited(uuid);
        prohibitedRepository.save(prohibitedModel);
        return prohibitedModel;
    }

    public UUID delete(UUID uuid) {
        var prohibited = prohibitedRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        prohibitedRepository.delete(prohibited);
        return uuid;
    }

}
