package net.bieli.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "product", description = "Rest API for product operations", tags = "Product API")
public class ApiProductController {

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Get product data by id", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public String getProductById(@PathVariable String id) {
        return String.format("{\"id\": \"{}\", \"status\": \"ok\"}", id); //new ProductImpl();
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @ApiOperation(value = "Add product with kind and quantities", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED"),
    }
    )
    public String postProduct(
            @RequestParam(value="kind", required=true, defaultValue="") String kind,
            @RequestParam(value="quantity", required=false, defaultValue="1") Integer quantity
    ) {
        return "{\"status\": \"ok\"}";
    }
}
