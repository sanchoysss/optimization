package by.alex.quote.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class QuoteItem {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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
        if (!(o instanceof QuoteItem)) return false;
        QuoteItem quoteItem = (QuoteItem) o;
        return id.equals(quoteItem.id) && quoteItemPrice.equals(quoteItem.quoteItemPrice) && productOffering.equals(quoteItem.productOffering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quoteItemPrice, productOffering);
    }
}
