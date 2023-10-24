package tech.marcelorsantos.controller;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.marcelorsantos.dto.ProductDTO;
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

    @POST
    public Response saveProduct(ProductDTO dto){
        Product product = service.saveProduct(dto);
        return Response.ok(product).status(201).build();
    }

    @Path("{id}")
    @PUT
    public Response updateProduct(@PathParam("id") Long id, ProductDTO dto){
        service.updateProduct(id, dto);
        return Response.status(204).build();
    }

}
