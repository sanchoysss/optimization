package by.alex.quote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Price {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(nullable = false)
    private String valueIncludingVAT;

    @Column(nullable = false)
    private String valueExcludingVAT;

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", valueIncludingVAT='" + valueIncludingVAT + '\'' +
                ", valueExcludingVAT='" + valueExcludingVAT + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return id.equals(price.id) && valueIncludingVAT.equals(price.valueIncludingVAT) && valueExcludingVAT.equals(price.valueExcludingVAT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valueIncludingVAT, valueExcludingVAT);
    }
}
