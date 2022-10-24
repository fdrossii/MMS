package Proyect.MMS.controller;

import Proyect.MMS.model.Sale;
import Proyect.MMS.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping("/api/findAllSale")
    public ResponseEntity<List<Sale>> findAllSale(){
        List<Sale> saleList = saleService.findAllSale();
        if(saleList == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(saleList);
        }
    }

    @DeleteMapping ("/api/deleteSale/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable  Long id){
        HttpStatus httpStatus = saleService.deleteSale(id);
        if(httpStatus == HttpStatus.ACCEPTED){
            return new ResponseEntity<>("La venta se elimino", httpStatus);
        }else{
            return new ResponseEntity<>("la venta a eliminar no existe", httpStatus);
        }
    }
}
