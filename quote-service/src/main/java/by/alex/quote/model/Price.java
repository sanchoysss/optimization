package by.alex.quote.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
