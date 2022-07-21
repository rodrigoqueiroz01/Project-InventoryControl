package inventory.control.service;

import inventory.control.model.EntryItemModel;
import inventory.control.repository.EntryItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EntryItemService {

    private static final String INVALIDATION_MESSAGE = "Item de entrada inválido.";

    private final EntryItemRepository entryItemRepository;

    public EntryItemModel save(EntryItemModel entryItemModel) {
        return entryItemRepository.save(entryItemModel);
    }

    public EntryItemModel findById(UUID uuid) {
        return entryItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
    }

    public List<EntryItemModel> findAll() {
        return entryItemRepository.findAll();
    }

    public EntryItemModel update(EntryItemModel entryItemModel, UUID uuid) {
        entryItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        entryItemModel.setCodEntryItem(uuid);
        entryItemRepository.save(entryItemModel);
        return entryItemModel;
    }

    public UUID delete(UUID uuid) {
        var entryItem = entryItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        entryItemRepository.delete(entryItem);
        return uuid;
    }

}
