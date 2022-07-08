package inventory.control.http.dto.mapper;

import inventory.control.http.dto.request.ConveyorRequest;
import inventory.control.http.dto.response.ConveyorResponse;
import inventory.control.model.ConveyorModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ConveyorMapper {

    public static ConveyorModel toModel(ConveyorRequest request) {
        return ConveyorModel
                .builder()
                .conveyor(request.getConveyor())
                .address(request.getAddress())
                .number(request.getNumber())
                .district(request.getDistrict())
                .zipCode(request.getZipCode())
                .cnpj(request.getCnpj())
                .subscription(request.getSubscription())
                .contact(request.getContact())
                .telephone(request.getTelephone())
                .cityModels(CityMapper.toModelList(request.getCodCityList()))
                .build();
    }

    public static ConveyorResponse toResponse(ConveyorModel conveyorModel) {
        return ConveyorResponse
                .builder()
                .codConveyor(conveyorModel.getCodConveyor())
                .conveyor(conveyorModel.getConveyor())
                .address(conveyorModel.getAddress())
                .number(conveyorModel.getNumber())
                .district(conveyorModel.getDistrict())
                .zipCode(conveyorModel.getZipCode())
                .cnpj(conveyorModel.getCnpj())
                .subscription(conveyorModel.getSubscription())
                .contact(conveyorModel.getContact())
                .telephone(conveyorModel.getTelephone())
                .cityResponseList(CityMapper.toResponseList(conveyorModel.getCityModels()))
                .build();
    }

    public static List<ConveyorResponse> toResponseList(List<ConveyorModel> conveyorModelList) {
        if (isNull(conveyorModelList) || conveyorModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return conveyorModelList
                    .stream()
                    .map(ConveyorMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

    public static List<ConveyorModel> toModelList(List<UUID> uuidList) {
        return uuidList
                .stream()
                .map(ConveyorMapper::createConveyor)
                .collect(Collectors.toList());
    }

    public static ConveyorModel createConveyor(UUID uuid) {
        return ConveyorModel
                .builder()
                .codConveyor(uuid)
                .build();
    }

}
