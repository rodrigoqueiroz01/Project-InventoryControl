package inventory.control.http.controller;

import inventory.control.http.dto.request.CategoryRequest;
import inventory.control.http.dto.response.CategoryResponse;
import inventory.control.http.mapper.CategoryMapper;
import inventory.control.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok()
                .body(CategoryMapper.toResponse(categoryService.save(CategoryMapper.toModel(categoryRequest))));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable String categoryId) {
        return ResponseEntity.ok()
                .body(CategoryMapper.toResponse(categoryService.findById(UUID.fromString(categoryId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(CategoryMapper.toResponseList(categoryService.findAll()));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> update(@PathVariable String categoryId, @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok()
                .body(CategoryMapper.toResponse(categoryService.update(CategoryMapper.toModel(categoryRequest), UUID.fromString(categoryId))));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<UUID> delete(@PathVariable String categoryId) {
        return ResponseEntity.ok()
                .body(categoryService.delete(UUID.fromString(categoryId)));
    }

}
