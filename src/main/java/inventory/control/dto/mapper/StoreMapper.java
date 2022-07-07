package inventory.control.dto.mapper;

import inventory.control.dto.request.StoreRequest;
import inventory.control.dto.response.StoreResponse;
import inventory.control.model.CityModel;
import inventory.control.model.StoreModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class StoreMapper {

    public static StoreModel toModel(StoreRequest request) {
        return StoreModel
                .builder()
                .name(request.getName())
                .address(request.getAddress())
                .number(request.getNumber())
                .district(request.getDistrict())
                .telephone(request.getTelephone())
                .subscription(request.getSubscription())
                .cnpj(request.getCnpj())
                .cityModels(CityMapper.toModelList(request.getCodCityList()))
                .build();
    }

    public static StoreResponse toResponse(StoreModel storeModel) {
        return StoreResponse
                .builder()
                .codStore(storeModel.getCodStore())
                .name(storeModel.getName())
                .address(storeModel.getAddress())
                .number(storeModel.getNumber())
                .district(storeModel.getDistrict())
                .telephone(storeModel.getTelephone())
                .subscription(storeModel.getSubscription())
                .cnpj(storeModel.getCnpj())
                .cityResponseList(CityMapper.toResponseList(storeModel.getCityModels()))
                .build();
    }

    public static List<StoreResponse> toResponseList(List<StoreModel> storeModelList) {
        if (isNull(storeModelList) || storeModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return storeModelList
                    .stream()
                    .map(StoreMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
