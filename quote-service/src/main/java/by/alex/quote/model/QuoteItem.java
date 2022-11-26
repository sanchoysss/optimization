package by.alex.quote.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class QuoteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Price quoteItemPrice;

    @ManyToOne
    private ProductOffering productOffering;

    @Override
    public String toString() {
        return "QuoteItem{" +
                "id=" + id +
                ", quoteItemPrice=" + quoteItemPrice +
                ", productOffering=" + productOffering +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuoteItem quoteItem)) return false;
        return id.equals(quoteItem.id) && quoteItemPrice.equals(quoteItem.quoteItemPrice) && productOffering.equals(quoteItem.productOffering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quoteItemPrice, productOffering);
    }
}
