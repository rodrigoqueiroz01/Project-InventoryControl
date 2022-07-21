package inventory.control.service;

import inventory.control.model.StoreModel;
import inventory.control.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StoreService {

    public static final String INVALIDATION_MESSAGE = "Loja inválida.";

    private final StoreRepository storeRepository;

    public StoreModel save(StoreModel storeModel) {
        return storeRepository.save(storeModel);
    }

    public StoreModel findByCod(UUID uuid) {
        return storeRepository.findById(uuid).orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
    }

    public Page<StoreModel> findAll(Pageable pageable, String district) {
        return this.storeRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (district != null && !district.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("district")),
                        "%" + district.toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        }, pageable);
    }

    public StoreModel update(StoreModel storeModel, UUID uuid) {
        storeRepository.findById(uuid).orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        storeModel.setCodStore(uuid);
        storeRepository.save(storeModel);
        return storeModel;
    }

    public UUID delete(UUID id) {
        var store = storeRepository.findById(id).orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        storeRepository.delete(store);
        return id;
    }

}
