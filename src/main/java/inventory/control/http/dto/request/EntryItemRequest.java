package inventory.control.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class EntryItemRequest {

    @NotNull(message = "O lote do item de entrada não foi informado.")
    private String batch;

    @NotNull(message = "A quantidade do item de entrada não foi informado.")
    private Integer amount;

    @NotNull(message = "O valor dos itens de entrada não foi informado.")
    private Double value;


    @NotNull(message = "O código do produto não foi informado.")
    private UUID codProduct;

    @NotNull(message = "O código de entrada não foi informado.")
    private UUID codProhibited;

}
