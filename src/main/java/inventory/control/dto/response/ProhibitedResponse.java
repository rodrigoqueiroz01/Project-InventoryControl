package inventory.control.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProhibitedResponse {

    private UUID codProhibited;
    private LocalDateTime requestDate;
    private LocalDateTime entryDate;
    private Double total;
    private Double shipping;
    private Integer invoiceNumber;
    private Double tax;

    private List<ConveyorResponse> conveyorResponseList;

}
