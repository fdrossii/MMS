package Proyect.MMS.controller;

import Proyect.MMS.model.Sale;
import Proyect.MMS.service.SaleService;
import Proyect.MMS.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sale")
@RestController
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping("/api/createSale")
    public ResponseEntity<String> createSale(@RequestBody Sale sale) throws ErrorResponse {
        saleService.createSale(sale);
        return new ResponseEntity<>("Sale was added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/api/findSaleById/{id}")
    public ResponseEntity<Sale> findSaleById(@PathVariable Long id){
        Sale sale = saleService.findSaleById(id);
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/api/findAllSale")
    public ResponseEntity<List<Sale>> findAllSale(){
        List<Sale> saleList = saleService.findAllSale();
        return new ResponseEntity<>(saleList, HttpStatus.ACCEPTED);
    }

    @DeleteMapping ("/api/deleteSale/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable  Long id){
        saleService.deleteSaleById(id);
        return ResponseEntity.ok("Sale was deleted successfully");
    }

    @PutMapping("/api/updateSale")
    public ResponseEntity<Sale> updateSale(@RequestBody Sale sale){
        saleService.updateSale(sale);
        return new ResponseEntity<>(sale, HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/addSaleDet/{saleId}/{saleDetId}")
    public ResponseEntity<String> addSaleDet (@PathVariable Long saleId,@PathVariable Long saleDetId){
        saleService.addSaleDet(saleId, saleDetId);
        return new ResponseEntity<>("Sale detail was added successfully", HttpStatus.ACCEPTED);
    }
}
