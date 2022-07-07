package inventory.control.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entry_item", schema = "public")
public class EntryItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codEntryItem;
    private String batch;
    private Integer amount;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "cod_product_fk")
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "cod_prohibited_fk")
    private ProhibitedModel prohibitedModel;

}
