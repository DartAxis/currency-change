package ru.dartinc.currency.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dartinc.currency.service.CbrService;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CbrService currencyService;
    @GetMapping("/rate/{code}")
    public BigDecimal currencyRate(@PathVariable("code")String code){
        return currencyService.requestByCurrencyCode(code);
    }

    @GetMapping("/rate")
    public Map<String,BigDecimal> allCurrencyRate(){
        return currencyService.callAllByCurrentDate();
    }
}
