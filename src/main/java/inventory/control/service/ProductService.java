package inventory.control.service;

import inventory.control.model.ProductModel;
import inventory.control.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    public static final String INVALIDATION_MESSAGE = "Produto inválido.";

    private final ProductRepository productRepository;

    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public ProductModel findById(UUID uuid) {
        return productRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel update(ProductModel productModel, UUID uuid) {
        productRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        productModel.setCodProduct(uuid);
        productRepository.save(productModel);
        return productModel;
    }

    public UUID delete(UUID uuid) {
        var product = productRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException(INVALIDATION_MESSAGE));
        productRepository.delete(product);
        return uuid;
    }

}
