package inventory.control.service;

import inventory.control.model.OutputItemModel;
import inventory.control.repository.OutputItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OutputItemService {

    public static final String INVALIDATION_MESSAGE = "Item de saída inválido.";

    private final OutputItemRepository outputItemRepository;

    public OutputItemModel save(OutputItemModel outputItemModel) {
        return outputItemRepository.save(outputItemModel);
    }

    public OutputItemModel findById(UUID uuid) {
        return outputItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
    }

    public List<OutputItemModel> findAll() {
        return outputItemRepository.findAll();
    }

    public OutputItemModel update(OutputItemModel outputItemModel, UUID uuid) {
        outputItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        outputItemModel.setCodOutputItem(uuid);
        outputItemRepository.save(outputItemModel);
        return outputItemModel;
    }

    public UUID delete(UUID uuid) {
        var outputItem = outputItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        outputItemRepository.delete(outputItem);
        return uuid;
    }

}
