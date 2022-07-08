package inventory.control.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CityRequest {

    @NotNull(message = "O nome da cidade não foi informado.")
    private String cityName;

    @NotNull(message = "A UF da cidade não foi informado.")
    private String uf;

}
