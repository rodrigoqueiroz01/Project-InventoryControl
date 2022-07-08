package inventory.control.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ConveyorRequest {

    @NotNull(message = "O nome da tranportadora não foi informado.")
    private String conveyor;

    @NotNull(message = "O endereço da transportadora não foi informado..")
    private String address;

    @NotNull(message = "O número do endereço da transportadora não foi informado.")
    private Integer number;

    @NotNull(message = "O bairro onde se encontra a transportadora não foi informado.")
    private String district;

    @NotNull(message = "O CEP da transportadora não foi informado.")
    private String zipCode;

    @NotNull(message = "O CNPJ da transportadora não informado.")
    private String cnpj;

    @NotNull(message = "A inscrição da transportadora não informado.")
    private String subscription;

    @NotNull(message = "O contato não informado.")
    private String contact;

    @NotNull(message = "O telefone da transportadora não iformado.")
    private String telephone;

    @NotNull(message = "O código da cidade não informado.")
    private List<UUID> codCityList;

}
