package inventory.control.http.mapper;

import inventory.control.http.dto.request.CityRequest;
import inventory.control.http.dto.response.CityResponse;
import inventory.control.model.CityModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class CityMapper {

    public static CityModel toModel(CityRequest request) {
        return CityModel
                .builder()
                .cityName(request.getCityName())
                .uf(request.getUf())
                .build();
    }

    public static CityResponse toResponse(CityModel cityModel) {
        return CityResponse
                .builder()
                .codCity(cityModel.getCodCity())
                .cityName(cityModel.getCityName())
                .uf(cityModel.getUf())
                .build();
    }

    public static List<CityResponse> toResponseList(List<CityModel> cityModelList) {
        if (isNull(cityModelList) || cityModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return cityModelList
                    .stream()
                    .map(CityMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

    public static List<CityModel> toModelList(List<UUID> uuidList) {
        return uuidList
                .stream()
                .map(CityMapper::createCity)
                .collect(Collectors.toList());
    }

    public static CityModel createCity(UUID uuid) {
        return CityModel
                .builder()
                .codCity(uuid)
                .build();
    }

}
