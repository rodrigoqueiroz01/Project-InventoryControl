package inventory.control.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProhibitedRequest {

    @NotNull(message = "A data solicitação do pedido não foi informada.")
    private LocalDate requestDate;

    @NotNull(message = "A data de entrada do pedido não informada.")
    private LocalDate entryDate;

    @NotNull(message = "O valor total do pedido não foi informado.")
    private Double total;

    @NotNull(message = "O valor do frete do pedido não foi informado.")
    private Double shipping;

    @NotNull(message = "O número da Nota Fiscal de Entrada do pedido não foi informado.")
    private Integer invoiceNumber;

    @NotNull(message = "O imposto não foi informado.")
    private Double tax;

    @NotNull(message = "O código da transportadora não foi informado.")
    private List<UUID> codConveyorList;

}
