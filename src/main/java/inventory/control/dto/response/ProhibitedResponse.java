package inventory.control.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProhibitedResponse {

    private UUID codProhibited;
    private LocalDate requestDate;
    private LocalDate entryDate;
    private Double total;
    private Double shipping;
    private Integer invoiceNumber;
    private Double tax;

    private List<ConveyorResponse> conveyorResponseList;

}
