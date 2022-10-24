package Proyect.MMS.service;

import Proyect.MMS.DTO.ProductDTO;
import Proyect.MMS.model.Product;
import Proyect.MMS.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product)  {
        productRepository.save(product);
    }

    public Product findProductById(Long id) {
        Optional <Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else{
            return null;
        }
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product){

        if (product.getId() == null){
            return null;
        }else{
            return productRepository.save(product);
        }
    }

    public HttpStatus deleteProduct(Long id){
       if(!productRepository.existsById(id)){
           return HttpStatus.NOT_FOUND;
       }
       else{
           productRepository.deleteById(id);
           return HttpStatus.ACCEPTED;
       }
    }

    public ProductDTO findProdDto (Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(optionalProduct.get().getId());
            productDTO.setName(optionalProduct.get().getName());
            productDTO.setPrice(optionalProduct.get().getPrice());
            return productDTO;
        }else{
            return null;
        }
    }

}
