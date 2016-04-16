package com.objectpartners.plummer.stockmarket.controller;

import com.objectpartners.plummer.stockmarket.domain.Exchange;
import com.objectpartners.plummer.stockmarket.domain.QuoteResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static com.objectpartners.plummer.stockmarket.controller.StockController.RESOURCE_ROOT_URL;

@RestController
@RequestMapping(RESOURCE_ROOT_URL)
@Api(value = "stocks", tags = "Stocks")
public class StockController {

    public static final String RESOURCE_ROOT_URL = "/stocks";
    private static final Random RANDOM = new Random();

    @RequestMapping(method = RequestMethod.GET, value = "/{symbol}")
    @ApiOperation(value = "Get Quote")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public QuoteResource getQuote(@PathVariable("symbol") String symbol) {
        return new QuoteResource(symbol,
                RANDOM.nextDouble() * 100,
                Exchange.values()[RANDOM.nextInt(Exchange.values().length)]);
    }
}