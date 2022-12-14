package Proyect.MMS.service;

import Proyect.MMS.DTO.ProductDTO;
import Proyect.MMS.exception.DeleteProductException;
import Proyect.MMS.exception.ProductListNotExistException;
import Proyect.MMS.exception.ProductNotExistException;
import Proyect.MMS.exception.ProductUpdateException;
import Proyect.MMS.model.Product;
import Proyect.MMS.repository.ProductRepository;
import Proyect.MMS.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product) throws ErrorResponse {
       try{
           productRepository.save(product);
       }catch (Exception e) {
          throw new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage(), LocalDate.now());
       }
    }

    public Product findProductById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("Wrong id format");
        }else{
            Optional <Product> optionalProduct = productRepository.findById(id);
            if(optionalProduct.isEmpty()){
                throw new ProductNotExistException("Product does not exist");
            }else{
                return optionalProduct.get();
            }
        }
    }

    public List<Product> findAllProducts()
    {
        List<Product> productList = productRepository.findAll();
        if(productList.isEmpty()){
            throw new ProductListNotExistException("List is empty");
        }else{
            return productList;
        }
    }

    public Product updateProduct(Product product){
        if (product.getId() == null){
            throw new ProductUpdateException("Product does not exist");
        }else{
            return productRepository.save(product);
        }
    }

    public void deleteProduct(Long id){
       if(id == null){
           throw new IllegalArgumentException("Wrong id format");
       }else{
           if(!productRepository.existsById(id)){
               throw new DeleteProductException("Product does not exist");
           }
           else{
               productRepository.deleteById(id);
           }
       }
    }

    public ProductDTO findProdDTO (Long id){
        if (id == null){
            throw new IllegalArgumentException("Wrong id format");
        }else{
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()){
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(optionalProduct.get().getId());
                productDTO.setName(optionalProduct.get().getName());
                productDTO.setPrice(optionalProduct.get().getPrice());
                return productDTO;
            }else{
                throw new ProductNotExistException("Product does not exist");
            }
        }
    }
}
