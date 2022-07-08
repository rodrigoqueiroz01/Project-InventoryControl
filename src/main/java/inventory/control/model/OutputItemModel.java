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
@Table(name = "output_item", schema = "public")
public class OutputItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codOutputItem;

    private String batch;
    private Integer amount;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "cod_product_fk")
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "cod_exit_fk")
    private ExitModel exitModel;

}
