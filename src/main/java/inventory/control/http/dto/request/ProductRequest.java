package inventory.control.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductRequest {

    @NotNull(message = "A descrição do produto não foi informado.")
    private String description;

    @NotNull(message = "O peso do produto não foi informado.")
    private Double weight;

    private Boolean controlled;

    @NotNull(message = "A quantidade mínima do produto não foi informado.")
    private Integer minimumAmount;

    @NotNull(message = "O código do fornecedor não foi informado.")
    private List<UUID> codProviderList;

    @NotNull(message = "O código da categoria não foi informado.")
    private UUID codCategory;

}
