package Proyect.MMS.controller;

import Proyect.MMS.DTO.ProductDTO;
import Proyect.MMS.model.Product;
import Proyect.MMS.service.ProductService;
import Proyect.MMS.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/api/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody  Product product) throws ErrorResponse {
        productService.addProduct(product);
        return new ResponseEntity<>("The product was added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/api/findProductById/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/api/findProdDTO/{id}")
    public ResponseEntity<ProductDTO> findProdDTO(@PathVariable Long id){
        return ResponseEntity.ok(productService.findProdDTO(id));
    }

    @GetMapping("/api/findAllProducts")
    public ResponseEntity<List<Product>> findAllProducts() {
        List <Product> productList = productService.findAllProducts();
        return ResponseEntity.ok(productList);
    }

   @PutMapping("/api/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product1 = productService.updateProduct(product);
        return ResponseEntity.ok(product1);
    }

   @DeleteMapping("/api/deleteProduct/{id}")
   public ResponseEntity<String> deleteProduct (@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product was deleted successfully", HttpStatus.ACCEPTED);
   }

}

