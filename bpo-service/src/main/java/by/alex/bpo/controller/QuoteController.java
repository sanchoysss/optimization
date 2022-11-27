package by.alex.bpo.controller;

import by.alex.bpo.dto.createquote.Quote;
import by.alex.bpo.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quote")
@AllArgsConstructor
public class QuoteController {

    private QuoteService quoteService;

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        return ResponseEntity.ok(quoteService.createQuote(quote));
    }
}
