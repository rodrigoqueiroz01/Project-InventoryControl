package inventory.control.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProviderRequest {

    @NotNull(message = "O nome do fornecedor não foi informado.")
    private String provider;

    @NotNull(message = "O endereço do fornecedor não foi informado.")
    private String address;

    @NotNull(message = "O número do endereço do fornecedor não foi informado.")
    private Integer number;

    @NotNull(message = "O bairro onde se encontra o fornecedor não foi informado.")
    private String district;

    @NotNull(message = "O CEP do fornecedor não foi informado.")
    private String cep;

    @NotNull(message = "O contato do fornecedor não foi informado.")
    private String contact;

    @NotNull(message = "O CNPJ do fornecedor não foi informado.")
    private String cnpj;

    @NotNull(message = "A inscrição do fornecedor não foi informada.")
    private String subscription;

    @NotNull(message = "O telefone do fornecedor não foi informado.")
    private String telephone;

    @NotNull(message = "O código da cidade não foi informado.")
    private List<UUID> codCityList;


}
