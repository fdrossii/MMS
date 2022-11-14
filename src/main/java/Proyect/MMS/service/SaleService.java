package Proyect.MMS.service;

import Proyect.MMS.exception.DeleteSaleException;
import Proyect.MMS.exception.SaleListException;
import Proyect.MMS.exception.SaleNotExistException;
import Proyect.MMS.model.Sale;
import Proyect.MMS.model.SaleDetail;
import Proyect.MMS.repository.SaleRepository;
import Proyect.MMS.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class  SaleService {


    @Autowired
    SaleRepository saleRepository;
    @Autowired
    SaleDetailService saleDetailService;

    public void createSale(Sale sale) throws ErrorResponse {
        try {
            saleRepository.save(sale);
        } catch (Exception e) {
            throw new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage(), LocalDate.now());
        }
    }

    public Sale findSaleById(Long id){
        if (id == null){
            throw new IllegalArgumentException("Sale ID is not valid");
        }else{
            Optional<Sale> optionalSale = saleRepository.findById(id);
            if(optionalSale.isPresent()){
                return optionalSale.get();
            }else{
                throw new SaleNotExistException("Sale does not exist");
            }
        }
    }

    public List<Sale> findAllSale(){
        List<Sale> saleList = saleRepository.findAll();
        if(saleList.isEmpty()){
            throw new SaleListException("Sale list is empty");
        }else{
            return saleList;
        }
    }

    public void updateSale (Sale sale){
        if(sale.getId()==null){
            throw new NoSuchElementException("Sale does not exist");
        }else{
            saleRepository.save(sale);
        }
    }

    public void deleteSaleById(Long id){
        if(id == null){
            throw new IllegalArgumentException("Id format is not valid");
        }else{
            if(!saleRepository.existsById(id)){
                throw new DeleteSaleException("Sale does not exist");
            }else{
                saleRepository.deleteById(id);
            }
        }
    }

    public void addSaleDet(Long saleId, Long saleDetId){
        if (saleId == null||saleDetId == null){
            throw new NoSuchElementException("Sale or sale detail id format is not valid");
        }else{
            SaleDetail saleDetail = saleDetailService.findById(saleDetId);
            Sale sale = findSaleById(saleId);
            sale.setSaleDetail(saleDetail);
            saleRepository.save(sale);
        }
    }

}
