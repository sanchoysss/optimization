package by.alex.quote.controller;

import by.alex.quote.dto.QuoteDto;
import by.alex.quote.model.Quote;
import by.alex.quote.service.QuoteService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quote")
@AllArgsConstructor
public class QuoteController {

    private QuoteService quoteService;
    private ModelMapper modelMapper;

    @PostMapping
    public QuoteDto createQuote(@RequestBody QuoteDto quoteDto) {
        Quote quote = modelMapper.map(quoteDto, Quote.class);
        return modelMapper.map(quoteService.createQuote(quote), QuoteDto.class);
    }
}
