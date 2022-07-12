package inventory.control.service;

import inventory.control.model.CategoryModel;
import inventory.control.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryModel save(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }

    public CategoryModel findById(UUID uuid) {
        return categoryRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Categoria inválida."));
    }

    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel update(CategoryModel categoryModel, UUID uuid) {
        categoryRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Categoria inválida."));
        categoryModel.setCodCategory(uuid);
        categoryRepository.save(categoryModel);
        return categoryModel;
    }

    public UUID delete(UUID uuid) {
        CategoryModel category = categoryRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Categoria inválida."));
        categoryRepository.delete(category);
        return uuid;
    }

}
