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

    private final ProductRepository productRepository;

    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public ProductModel findById(UUID uuid) {
        return productRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Produto não encontrado!"));
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel update(ProductModel productModel, UUID uuid) {
        productRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Produto não encontrado!"));
        productModel.setCodProduct(uuid);
        productRepository.save(productModel);
        return productModel;
    }

    public UUID delete(UUID uuid) {
        ProductModel product = productRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Produto não encontrado!"));
        productRepository.delete(product);
        return uuid;
    }

}
