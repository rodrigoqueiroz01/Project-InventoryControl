package inventory.control.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {

    private UUID codProvider;
    private String provider;
    private String address;
    private Integer number;
    private String district;
    private String cep;
    private String contact;
    private String cnpj;
    private String subscription;
    private String telephone;

    private List<CityResponse> cityResponseList;

}
