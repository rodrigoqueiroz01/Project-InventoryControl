package inventory.control.http.mapper;

import inventory.control.http.dto.response.CategoryResponse;
import inventory.control.http.dto.request.CategoryRequest;
import inventory.control.model.CategoryModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class CategoryMapper {

    public static CategoryModel toModel(CategoryRequest categoryRequest) {
        return CategoryModel
                .builder()
                .name(categoryRequest.getName())
                .build();
    }

    public static CategoryResponse toResponse(CategoryModel categoryModel) {
        return CategoryResponse
                .builder()
                .codCategory(categoryModel.getCodCategory())
                .name(categoryModel.getName())
                .build();
    }

    public static List<CategoryResponse> toResponseList(List<CategoryModel> categoryModelList) {
        if (isNull(categoryModelList) || categoryModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return categoryModelList
                    .stream()
                    .map(CategoryMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
