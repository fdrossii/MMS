package Proyect.MMS.service;

import Proyect.MMS.DTO.ProductDTO;
import Proyect.MMS.model.SaleDetail;
import Proyect.MMS.repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleDetailService {
    @Autowired
    SaleDetailRepository saleDetailRepository;
    @Autowired
    ProductService productService;

    public void createSaleDetail(SaleDetail saleDetail){
        saleDetailRepository.save(saleDetail);
    }

    public SaleDetail findSaleDetailById (Long id){
        Optional<SaleDetail> optSaleDetail = saleDetailRepository.findById(id);
        if (optSaleDetail.isPresent()){
            return optSaleDetail.get();
        }else{
            return null;
        }
    }

    public SaleDetail addProductToList(Long saleDetId, Long prodId){
       ProductDTO product = productService.findProdDto(prodId);
       Optional <SaleDetail> optSaleDetail = saleDetailRepository.findById(saleDetId);
       if(product == null || optSaleDetail.isEmpty()){
           return null;
       }else{
           optSaleDetail.get().getProductList().add(product);
           return saleDetailRepository.save(optSaleDetail.get());
       }
    }

    public HttpStatus deleteSailDetailById (Long id){
        if (!saleDetailRepository.existsById(id)){
            return HttpStatus.NOT_FOUND;
        }else{
            saleDetailRepository.deleteById(id);
            return HttpStatus.ACCEPTED;
        }
    }

    public SaleDetail updateSaleDetail (SaleDetail saleDetail){
        if (saleDetail.getId()==null){
            return null;
        }else {
            return saleDetailRepository.save(saleDetail);
        }
    }

    public List<SaleDetail> findAllSaleDet (){
        return saleDetailRepository.findAll();
    }


}
