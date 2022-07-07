package inventory.control.dto.mapper;

import inventory.control.dto.request.OutpuItemRequest;
import inventory.control.dto.response.OutputItemResponse;
import inventory.control.model.ExitModel;
import inventory.control.model.OutputItemModel;
import inventory.control.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class OutputItemMapper {

    public static OutputItemModel toModel(OutpuItemRequest request) {
        return OutputItemModel
                .builder()
                .batch(request.getBatch())
                .amount(request.getAmount())
                .value(request.getValue())
                .productModel(ProductModel.builder().codProduct(request.getCodProduct()).build())
                .exitModel(ExitModel.builder().codExit(request.getCodExit()).build())
                .build();
    }

    public static OutputItemResponse toResponse(OutputItemModel outputItemModel) {
        return OutputItemResponse
                .builder()
                .codOutputItem(outputItemModel.getCodOutputItem())
                .batch(outputItemModel.getBatch())
                .amount(outputItemModel.getAmount())
                .value(outputItemModel.getValue())
                .productResponse(ProductMapper.toResponse(outputItemModel.getProductModel()))
                .exitResponse(ExitMapper.toResponse(outputItemModel.getExitModel()))
                .build();
    }

    public static List<OutputItemResponse> toResponseList(List<OutputItemModel> outputItemModelList) {
        if (isNull(outputItemModelList) || outputItemModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return outputItemModelList
                    .stream()
                    .map(OutputItemMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
