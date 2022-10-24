package Proyect.MMS.service;

import Proyect.MMS.model.Sale;
import Proyect.MMS.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {


    @Autowired
    SaleRepository saleRepository;

    public void createSale(Sale sale){
        saleRepository.save(sale);
    }

    public Sale findSaleById(Long id){
        Optional<Sale> optionalSale = saleRepository.findById(id);
        if(optionalSale.isPresent()){
            return optionalSale.get();
        }else{
            return null;
        }
    }

    public List<Sale> findAllSale(){
        List<Sale> saleList = saleRepository.findAll();
        if(saleList.isEmpty()){
            return null;
        }else{
            return saleList;
        }
    }

    public HttpStatus deleteSale(Long id){
        if(!saleRepository.existsById(id)){
            return HttpStatus.NOT_FOUND;
        }else{
            saleRepository.deleteById(id);
            return HttpStatus.ACCEPTED;
        }
    }

}
