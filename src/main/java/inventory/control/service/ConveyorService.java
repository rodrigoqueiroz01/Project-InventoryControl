package inventory.control.service;

import inventory.control.model.ConveyorModel;
import inventory.control.repository.ConveyorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConveyorService {

    private final ConveyorRepository conveyorRepository;

    public ConveyorModel save(ConveyorModel conveyorModel) {
        return conveyorRepository.save(conveyorModel);
    }

    public ConveyorModel findById(UUID uuid) {
        return conveyorRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Transportadora inválida."));
    }

    public List<ConveyorModel> findAll() {
        return conveyorRepository.findAll();
    }

    public ConveyorModel update(ConveyorModel conveyorModel, UUID uuid) {
        conveyorRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Transportadora inválida."));
        conveyorModel.setCodConveyor(uuid);
        conveyorRepository.save(conveyorModel);
        return conveyorModel;
    }

    public UUID delete(UUID uuid) {
        var conveyor = conveyorRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Transportadora inválida."));
        conveyorRepository.delete(conveyor);
        return uuid;
    }

}
