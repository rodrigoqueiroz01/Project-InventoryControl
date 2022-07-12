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
@Table(name = "exit", schema = "public")
public class ExitModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codExit;

    private Double total;

    private Double shipping;

    private Double tax;

    @ManyToMany
    @JoinTable(
            name = "exit_conveyor", schema = "public",
            joinColumns = @JoinColumn(name = "cod_exit_fk"),
            inverseJoinColumns = @JoinColumn(name = "cod_conveyor_fk")
    )
    private List<ConveyorModel> conveyorModels;

    @ManyToOne
    @JoinColumn(name = "store_cod")
    private StoreModel storeModel;

}
