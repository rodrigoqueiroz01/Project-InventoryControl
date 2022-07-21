package inventory.control.service;

import inventory.control.model.ProviderModel;
import inventory.control.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProviderService {

    public static final String INVALIDATION_MESSAGE = "Fornecedor inválido.";

    private final ProviderRepository providerRepository;

    public ProviderModel save(ProviderModel providerModel) {
        return providerRepository.save(providerModel);
    }

    public ProviderModel findById(UUID uuid) {
        return providerRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
    }

    public List<ProviderModel> findAll() {
        return providerRepository.findAll();
    }

    public ProviderModel update(ProviderModel providerModel, UUID uuid) {
        providerRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        providerModel.setCodProvider(uuid);
        providerRepository.save(providerModel);
        return providerModel;
    }

    public UUID delete(UUID uuid) {
        var provider = providerRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        providerRepository.delete(provider);
        return uuid;
    }

}
