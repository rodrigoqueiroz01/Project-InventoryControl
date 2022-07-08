package inventory.control.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class StoreRequest {

    @NotNull(message = "O nome da loja não foi informado.")
    private String name;

    @NotNull(message = "O endereço da loja não foi informado.")
    private String address;

    @NotNull(message = "O número da loja não foi informado.")
    private Integer number;

    @NotNull(message = "O bairro da loja não foi informado.")
    private String district;

    @NotNull(message = "O telefone da loja não foi informado.")
    private String telephone;

    @NotNull(message = "A inscrição da loja não foi informada.")
    private String subscription;

    @NotNull(message = "O CNPJ da loja não foi informado.")
    private String cnpj;

    @NotNull(message = "O código da cidade não foi encontrado.")
    private List<UUID> codCityList;

}
