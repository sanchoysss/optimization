package by.alex.quote.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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
        if (!(o instanceof Quote)) return false;
        Quote quote = (Quote) o;
        return id.equals(quote.id) && state.equals(quote.state) && quoteDate.equals(quote.quoteDate) && customer.equals(quote.customer) && totalPrice.equals(quote.totalPrice) && quoteItems.equals(quote.quoteItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, quoteDate, customer, totalPrice, quoteItems);
    }
}
