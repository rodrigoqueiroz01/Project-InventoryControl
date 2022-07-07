package inventory.control.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prohibited", schema = "public")
public class ProhibitedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codProhibited;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "entry_date")
    private LocalDate entryDate;
    private Double total;
    private Double shipping;
    @Column(name = "invoice_number")
    private Integer invoiceNumber;
    private Double tax;

    @ManyToMany
    @JoinTable(
            name = "prohibited_conveyor",
            schema = "public",
            joinColumns = @JoinColumn(name = "cod_prohibiteed_fk"),
            inverseJoinColumns = @JoinColumn(name = "cod_conveyor_fk")
    )
    private List<ConveyorModel> conveyorModels;

}
