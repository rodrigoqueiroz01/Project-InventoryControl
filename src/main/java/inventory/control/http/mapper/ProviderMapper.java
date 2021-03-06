package inventory.control.http.mapper;

import inventory.control.http.dto.request.ProviderRequest;
import inventory.control.http.dto.response.ProviderResponse;
import inventory.control.model.ProviderModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ProviderMapper {

    public static ProviderModel toModel(ProviderRequest request) {
        return ProviderModel
                .builder()
                .provider(request.getProvider())
                .address(request.getAddress())
                .number(request.getNumber())
                .district(request.getDistrict())
                .cep(request.getCep())
                .contact(request.getContact())
                .cnpj(request.getCnpj())
                .subscription(request.getSubscription())
                .telephone(request.getTelephone())
                .cityModels(CityMapper.toModelList(request.getCodCityList()))
                .build();
    }

    public static ProviderResponse toResponse(ProviderModel providerModel) {
        return ProviderResponse
                .builder()
                .codProvider(providerModel.getCodProvider())
                .provider(providerModel.getProvider())
                .address(providerModel.getAddress())
                .number(providerModel.getNumber())
                .district(providerModel.getDistrict())
                .cep(providerModel.getCep())
                .contact(providerModel.getContact())
                .cnpj(providerModel.getCnpj())
                .subscription(providerModel.getSubscription())
                .telephone(providerModel.getTelephone())
                .cityResponseList(CityMapper.toResponseList(providerModel.getCityModels()))
                .build();
    }

    public static List<ProviderResponse> toResponseList(List<ProviderModel> providerModelList) {
        if (isNull(providerModelList) || providerModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return providerModelList
                    .stream()
                    .map(ProviderMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

    public static List<ProviderModel> toModelList(List<UUID> uuidList) {
        return uuidList
                .stream()
                .map(ProviderMapper::createProvider)
                .collect(Collectors.toList());
    }

    public static ProviderModel createProvider(UUID uuid) {
        return ProviderModel
                .builder()
                .codProvider(uuid)
                .build();
    }

}
