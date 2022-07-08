package inventory.control.service;

import inventory.control.model.StoreModel;
import inventory.control.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StoreService {

    private StoreRepository storeRepository;

    public StoreModel save(StoreModel storeModel) {
        return storeRepository.save(storeModel);
    }

    public StoreModel findByCod(UUID uuid) {
        return storeRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Loja não encontrada!"));
    }

    public List<StoreModel> findAll() {
        return storeRepository.findAll();
    }

    public StoreModel update(StoreModel storeModel, UUID uuid) {
        storeRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Loja não encontrada!"));
        storeModel.setCodStore(uuid);
        storeRepository.save(storeModel);
        return storeModel;
    }

    public UUID delete(UUID id) {
        StoreModel store = storeRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Loja não encontrada!"));
        storeRepository.delete(store);
        return id;
    }

}