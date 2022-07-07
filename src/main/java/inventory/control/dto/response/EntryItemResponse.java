package inventory.control.dto.response;

import inventory.control.model.ProhibitedModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryItemResponse {

    private UUID codEntryItem;
    private String batch;
    private Integer amount;
    private Double value;

    private ProductResponse productResponse;
    private ProhibitedResponse prohibitedResponse;

}
