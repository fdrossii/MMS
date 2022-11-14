package Proyect.MMS.controller;

import Proyect.MMS.model.SaleDetail;
import Proyect.MMS.service.SaleDetailService;
import Proyect.MMS.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/saleDetail")
@RestController
public class SaleDetailController {

    @Autowired
    SaleDetailService saleDetailService;

    @PostMapping("/api/createSaleDetail")
    public ResponseEntity<String> createSaleDetail(@RequestBody SaleDetail saleDetail) throws ErrorResponse {
        saleDetailService.createSaleDetail(saleDetail);
        return new ResponseEntity<>("The sale detail was added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/api/findSaleDetailById/{id}")
    public ResponseEntity<SaleDetail> findSaleDetailById(@PathVariable Long id){
        SaleDetail saleDetail = saleDetailService.findById(id);
        return ResponseEntity.ok(saleDetail);
    }

    @GetMapping
    public ResponseEntity<List<SaleDetail>> findAllSaleDet(){
        List<SaleDetail> saleDetail = saleDetailService.findAllSaleDet();
        return new ResponseEntity<>(saleDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/deleteSaleDetById/{id}")
    public ResponseEntity<String> deleteSaleDetailById(@PathVariable Long id){
        saleDetailService.deleteSailDetailById(id);
        return ResponseEntity.ok("Sale detail was deleted successfully");
    }

    @PutMapping("/api/addProductToList/{saleDetId}/{prodId}")
    public ResponseEntity<String> addProductToList(@PathVariable Long saleDetId,@PathVariable Long prodId){
        saleDetailService.addProductToList(saleDetId, prodId);
        return ResponseEntity.ok("Product was added succsessfully");
    }

    @PutMapping("/api/updateSaleDetail")
    public ResponseEntity<SaleDetail> updateSaleDetail (@RequestBody SaleDetail saleDetail){
        SaleDetail saleDetail1 = saleDetailService.updateSaleDetail(saleDetail);
        return ResponseEntity.ok(saleDetail1);
    }
}
