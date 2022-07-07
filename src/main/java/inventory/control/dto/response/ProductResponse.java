package inventory.control.dto.response;

import inventory.control.model.CategoryModel;
import inventory.control.model.ProviderModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private UUID codProduct;
    private String description;
    private Double weight;
    private Boolean controlled;
    private Integer minimumAmount;

    private List<ProviderResponse> providerResponseList;
    private String nameCategory;

}
