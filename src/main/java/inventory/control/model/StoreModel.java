package inventory.control.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store", schema = "public")
public class StoreModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codStore;

    private String name;

    private String address;

    private Integer number;

    private String district;

    private String telephone;

    private String subscription;

    private String cnpj;

    @OneToMany(mappedBy = "storeModel")
    private List<ExitModel> exitModels;

    @ManyToMany
    @JoinTable(
            name = "store_city", schema = "public",
            joinColumns = @JoinColumn(name = "cod_store_fk"),
            inverseJoinColumns = @JoinColumn(name = "cod_city_fk")
    )
    private List<CityModel> cityModels;

}
