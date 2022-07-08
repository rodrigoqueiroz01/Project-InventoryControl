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
@Table(name = "city", schema = "public")
public class CityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codCity;

    @Column(name = "city_name")
    private String cityName;

    private String uf;

}
