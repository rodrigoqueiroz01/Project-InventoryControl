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

    private EntryItemRepository entryItemRepository;

    public EntryItemModel save(EntryItemModel entryItemModel) {
        return entryItemRepository.save(entryItemModel);
    }

    public EntryItemModel findById(UUID uuid) {
        return entryItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Item de entrada inválido."));
    }

    public List<EntryItemModel> findAll() {
        return entryItemRepository.findAll();
    }

    public EntryItemModel update(EntryItemModel entryItemModel, UUID uuid) {
        entryItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Item de entrada inválido."));
        entryItemModel.setCodEntryItem(uuid);
        entryItemRepository.save(entryItemModel);
        return entryItemModel;
    }

    public UUID delete(UUID uuid) {
        var entryItem = entryItemRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Item de entrada inválido."));
        entryItemRepository.delete(entryItem);
        return uuid;
    }

}
