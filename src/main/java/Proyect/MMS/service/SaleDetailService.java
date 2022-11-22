package Proyect.MMS.service;

import Proyect.MMS.exception.DeleteSaleDetException;
import Proyect.MMS.exception.SaleDetListException;
import Proyect.MMS.exception.SaleDetailException;
import Proyect.MMS.model.Product;
import Proyect.MMS.model.SaleDetail;
import Proyect.MMS.repository.SaleDetailRepository;
import Proyect.MMS.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SaleDetailService {
    @Autowired
    SaleDetailRepository saleDetailRepository;
    @Autowired
    ProductService productService;

    public void createSaleDetail(SaleDetail saleDetail) throws ErrorResponse {
        try{
            saleDetailRepository.save(saleDetail);
        }catch (Exception e){
            throw new ErrorResponse(HttpStatus.CONFLICT.value(),e.getMessage(), LocalDate.now());
        }
    }

    public SaleDetail findById (Long id){
        if (id == null){
            throw new IllegalArgumentException("Wrong id format");
        }else{
            Optional<SaleDetail> optionalSaleDetail = saleDetailRepository.findById(id);
            if (optionalSaleDetail.isEmpty()){
                throw new SaleDetailException("Sale Detail does not exist");
            }else{
                return optionalSaleDetail.get();
            }
        }
    }

    public List<SaleDetail> findAllSaleDet(){
        List<SaleDetail> saleDetailList = saleDetailRepository.findAll();
        if (saleDetailList.isEmpty()){
            throw new SaleDetListException("Sales details not found");
        }else{
            return saleDetailList;
        }
    }

    public void addProductToList(Long saleDetId, Long prodId){
       if(saleDetId == null || prodId == null){
           throw new IllegalArgumentException("Wrong if format");
       }else{
           Product product = productService.findProductById(prodId);
           Optional <SaleDetail> optionalSaleDetail = saleDetailRepository.findById(saleDetId);
           if(optionalSaleDetail.isEmpty()){
               throw new NoSuchElementException("Sale detail not exist");
           }else{
               optionalSaleDetail.get().getProductList().add(product);
               saleDetailRepository.save(optionalSaleDetail.get());
           }
       }
    }

    public void deleteSailDetailById (Long id){
        if(id == null){
            throw new IllegalArgumentException("Wrong id format");
        }else{
            if (!saleDetailRepository.existsById(id)){
                throw new DeleteSaleDetException("Sale detail does not exist");
            }else{
                saleDetailRepository.deleteById(id);
            }
        }
    }

    public SaleDetail updateSaleDetail (SaleDetail saleDetail){
        if (saleDetail.getId()==null){
            throw new NoSuchElementException("Sale detail does not exist");
        }else {
            return saleDetailRepository.save(saleDetail);
        }
    }
}
