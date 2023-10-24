package tech.marcelorsantos.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.marcelorsantos.entity.Product;
import tech.marcelorsantos.service.ProductService;

import java.util.List;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService service;

    @GET
    public Response listProducts(){
        List<Product> products = service.productList();
        return Response.ok(products).build();
    }
}
