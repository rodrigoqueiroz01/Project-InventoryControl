package inventory.control.dto.mapper;

import inventory.control.dto.request.ProhibitedRequest;
import inventory.control.dto.response.ProhibitedResponse;
import inventory.control.model.ProhibitedModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ProhibitedMapper {

    public static ProhibitedModel toModel(ProhibitedRequest request) {
        return ProhibitedModel
                .builder()
                .requestDate(request.getRequestDate())
                .entryDate(request.getEntryDate())
                .total(request.getTotal())
                .shipping(request.getShipping())
                .invoiceNumber(request.getInvoiceNumber())
                .tax(request.getTax())
                .conveyorModels(ConveyorMapper.toModelList(request.getCodConveyorList()))
                .build();
    }

    public static ProhibitedResponse toResponse(ProhibitedModel prohibitedModel) {
        return ProhibitedResponse
                .builder()
                .codProhibited(prohibitedModel.getCodProhibited())
                .requestDate(prohibitedModel.getRequestDate())
                .entryDate(prohibitedModel.getEntryDate())
                .total(prohibitedModel.getTotal())
                .shipping(prohibitedModel.getShipping())
                .invoiceNumber(prohibitedModel.getInvoiceNumber())
                .tax(prohibitedModel.getTax())
                .conveyorResponseList(ConveyorMapper.toResponseList(prohibitedModel.getConveyorModels()))
                .build();
    }

    public static List<ProhibitedResponse> toResponseList(List<ProhibitedModel> prohibitedModelList) {
        if (isNull(prohibitedModelList) || prohibitedModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return prohibitedModelList
                    .stream()
                    .map(ProhibitedMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
