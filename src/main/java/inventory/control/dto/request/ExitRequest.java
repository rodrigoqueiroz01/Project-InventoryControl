package inventory.control.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ExitRequest {

    @NotNull(message = "O valor total de saída não foi informado.")
    private Double total;

    @NotNull(message = "O valor do frete de saída não foi informado.")
    private Double shipping;

    @NotNull(message = "O imposto de saída não foi informado.")
    private Double tax;

    @NotNull(message = "O código da transportadora não foi informado.")
    private List<UUID> codConveyorList;

    @NotNull(message = "O código da loja não foi informado.")
    private UUID codStore;

}
