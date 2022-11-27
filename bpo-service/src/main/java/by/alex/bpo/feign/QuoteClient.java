package by.alex.bpo.feign;

import by.alex.bpo.dto.createquote.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "quote-service", path = "/api/v1/quote")
public interface QuoteClient {

    @PostMapping
    Quote createQuote(@RequestBody Quote quote);
}
