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

    private ConveyorRepository conveyorRepository;

    public ConveyorModel save(ConveyorModel conveyorModel) {
        return conveyorRepository.save(conveyorModel);
    }

    public ConveyorModel findById(UUID uuid) {
        return conveyorRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Transportadora não encontrada!"));
    }

    public List<ConveyorModel> findAll() {
        return conveyorRepository.findAll();
    }

    public ConveyorModel update(ConveyorModel conveyorModel, UUID uuid) {
        conveyorRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Transportadora não encontrada!"));
        conveyorModel.setCodConveyor(uuid);
        conveyorRepository.save(conveyorModel);
        return conveyorModel;
    }

    public UUID delete(UUID uuid) {
        ConveyorModel conveyor = conveyorRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Transportadora não encontrada!"));
        conveyorRepository.delete(conveyor);
        return uuid;
    }

}
