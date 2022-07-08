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
@Table(name = "conveyor", schema = "public")
public class ConveyorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codConveyor;

    private String conveyor;
    private String address;
    private Integer number;
    private String district;

    @Column(name = "zip_code")
    private String zipCode;

    private String cnpj;
    private String subscription;
    private String contact;
    private String telephone;

    @ManyToMany
    @JoinTable(
            name = "conveyor_city", schema = "public",
            joinColumns = @JoinColumn(name = "cod_conveyor_fk"),
            inverseJoinColumns = @JoinColumn(name = "cod_city_fk")
    )
    private List<CityModel> cityModels;

}
