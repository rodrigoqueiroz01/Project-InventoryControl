package inventory.control.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category", schema = "public")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codCategory;
    private String name;

}
