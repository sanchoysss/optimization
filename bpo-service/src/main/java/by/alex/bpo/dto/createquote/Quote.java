package by.alex.bpo.dto.createquote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote {

    private UUID id;

    @Valid
    @NotNull(message = "state can't be null")
    @NotBlank(message = "state can't be empty")
    private String state;

    @Valid
    @NotNull(message = "quoteDate can't be null")
    @NotBlank(message = "quoteDate can't be empty")
    private ZonedDateTime quoteDate;

    @Valid
    @NotNull(message = "customer can't be null")
    @NotEmpty(message = "customer can't be empty")
    private Customer customer;

    private Price totalPrice;

    @Valid
    @NotNull(message = "quoteItems can't be null")
    @NotEmpty(message = "quoteItems can't be empty")
    private List<QuoteItem> quoteItems;
}
