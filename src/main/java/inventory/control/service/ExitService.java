package inventory.control.service;

import inventory.control.model.ExitModel;
import inventory.control.repository.ExitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExitService {

    public static final String INVALIDATION_MESSAGE = "Saída inválida.";

    private final ExitRepository exitRepository;

    public ExitModel save(ExitModel exitModel) {
        return exitRepository.save(exitModel);
    }

    public ExitModel findById(UUID uuid) {
        return exitRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
    }

    public List<ExitModel> findAll() {
        return exitRepository.findAll();
    }

    public ExitModel update(ExitModel exitModel, UUID uuid) {
        exitRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        exitModel.setCodExit(uuid);
        exitRepository.save(exitModel);
        return exitModel;
    }

    public UUID delete(UUID uuid) {
        var exit = exitRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        exitRepository.delete(exit);
        return uuid;
    }

}
