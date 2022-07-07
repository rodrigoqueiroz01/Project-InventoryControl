package inventory.control.dto.response;

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
public class ExitResponse {

    private UUID codExit;
    private Double total;
    private Double shipping;
    private Double tax;

    private List<ConveyorResponse> conveyorResponseList;
    private StoreResponse storeResponse;

}
