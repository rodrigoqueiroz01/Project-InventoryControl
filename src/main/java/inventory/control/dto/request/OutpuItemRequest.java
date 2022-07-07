package inventory.control.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class OutpuItemRequest {

    @NotNull(message = "O lote do item de saida não foi informado.")
    private String batch;

    @NotNull(message = "A quantidade do item de saída não informado.")
    private Integer amount;

    @NotNull(message = "O valor do item de saída não foi informado.")
    private Double value;

    @NotNull(message = "O código do produto não foi informado.")
    private UUID codProduct;

    @NotNull(message = "O código de saída não foi informado.")
    private UUID codExit;

}
