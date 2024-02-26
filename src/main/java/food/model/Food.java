package food.model;

import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private double price;
}
