package Proyect.MMS.controller;

import Proyect.MMS.model.Product;
import Proyect.MMS.service.ProductService;
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
    public ResponseEntity<String> addProduct(@RequestBody  Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>("The product was added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/api/findProductById/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(product);
        }
    }

    @GetMapping("/api/findAllProducts")
    public ResponseEntity<List<Product>> findAllProducts() {
        List <Product> productList = productService.findAllProducts();

        if (productList.isEmpty()) {
            return new ResponseEntity<>(productList, HttpStatus.NO_CONTENT);

        }else{
            return ResponseEntity.ok(productList);
        }
    }

   @PutMapping("/api/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product1 = productService.updateProduct(product);

        if(product1 == null) {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(product1);
        }
   }

   @DeleteMapping("/api/deleteProduct/{id}")
   public ResponseEntity<String> deleteProduct (@PathVariable Long id){
        if (productService.deleteProduct(id) == HttpStatus.NOT_FOUND){
            return new ResponseEntity<>("Trying to delete a non existing product", HttpStatus.NOT_FOUND);
        }

       return new ResponseEntity<>("Product was deleted successfully", HttpStatus.ACCEPTED);
   }

}

