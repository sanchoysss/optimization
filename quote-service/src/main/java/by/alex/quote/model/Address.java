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
public class Address {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String houseNumber;

    private String houseNumberExtension;

    private String flatNumber;

    @Column(nullable = false)
    private String postCode;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", houseNumberExtension='" + houseNumberExtension + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id) && country.equals(address.country) && city.equals(address.city) && street.equals(address.street) && houseNumber.equals(address.houseNumber) && Objects.equals(houseNumberExtension, address.houseNumberExtension) && Objects.equals(flatNumber, address.flatNumber) && postCode.equals(address.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street, houseNumber, houseNumberExtension, flatNumber, postCode);
    }
}
