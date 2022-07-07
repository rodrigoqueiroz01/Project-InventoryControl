package inventory.control.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryRequest {

    @NotNull(message = "O nome da categoria não foi informado.")
    private String name;

}
