package by.alex.quote.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteDto {

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
    private CustomerDTO customer;

    @Valid
    @NotNull(message = "totalPrice can't be null")
    @NotEmpty(message = "totalPrice can't be empty")
    private PriceDTO totalPrice;

    @Valid
    @NotNull(message = "quoteItems can't be null")
    @NotEmpty(message = "quoteItems can't be empty")
    private List<QuoteItemDTO> quoteItems;
}
