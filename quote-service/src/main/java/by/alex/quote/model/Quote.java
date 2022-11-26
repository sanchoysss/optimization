package by.alex.quote.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private ZonedDateTime quoteDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(nullable = false)
    private Customer customer;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(nullable = false)
    private Price totalPrice;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(nullable = false)
    private List<QuoteItem> quoteItems;

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", quoteDate=" + quoteDate +
                ", customer=" + customer +
                ", totalPrice=" + totalPrice +
                ", quoteItems=" + quoteItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quote quote)) return false;
        return id.equals(quote.id) && state.equals(quote.state) && quoteDate.equals(quote.quoteDate) && customer.equals(quote.customer) && totalPrice.equals(quote.totalPrice) && quoteItems.equals(quote.quoteItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, quoteDate, customer, totalPrice, quoteItems);
    }
}
