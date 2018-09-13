package br.com.k21;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @RequestMapping("/calculator")
    public BigDecimal calculator(@RequestParam(value="sale", defaultValue="0") BigDecimal sale) {
        return CommissionCalculator.getCommission(sale);
    }
}