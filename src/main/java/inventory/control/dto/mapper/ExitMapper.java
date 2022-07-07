package inventory.control.dto.mapper;

import inventory.control.dto.request.ExitRequest;
import inventory.control.dto.response.ExitResponse;
import inventory.control.model.ExitModel;
import inventory.control.model.StoreModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ExitMapper {

    public static ExitModel toModel(ExitRequest request) {
        return ExitModel
                .builder()
                .total(request.getTotal())
                .shipping(request.getShipping())
                .tax(request.getTax())
                .conveyorModels(ConveyorMapper.toModelList(request.getCodConveyorList()))
                .storeModel(StoreModel.builder().codStore(request.getCodStore()).build())
                .build();
    }

    public static ExitResponse toResponse(ExitModel exitModel) {
        return ExitResponse
                .builder()
                .codExit(exitModel.getCodExit())
                .total(exitModel.getTotal())
                .shipping(exitModel.getShipping())
                .tax(exitModel.getTax())
                .storeResponse(StoreMapper.toResponse(exitModel.getStoreModel()))
                .build();
    }

    public static List<ExitResponse> toResponseList(List<ExitModel> exitModelList) {
        if (isNull(exitModelList) || exitModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return exitModelList
                    .stream()
                    .map(ExitMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
