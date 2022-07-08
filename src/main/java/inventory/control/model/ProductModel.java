package inventory.control.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "public")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codProduct;

    private String description;
    private Double weight;
    private Boolean controlled;

    @Column(name = "minimum_amount")
    private Integer minimumAmount;

    @ManyToMany
    @JoinTable(
            name = "product_provider", schema = "public",
            joinColumns = @JoinColumn(name = "cod_product_fk"),
            inverseJoinColumns = @JoinColumn(name = "cod_provider_fk")
    )
    private List<ProviderModel> providerModels;

    @ManyToOne
    @JoinColumn(name = "cod_category_fk")
    private CategoryModel categoryModel;

}
