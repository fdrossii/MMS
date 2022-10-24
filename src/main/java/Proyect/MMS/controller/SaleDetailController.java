package Proyect.MMS.controller;

import Proyect.MMS.model.SaleDetail;
import Proyect.MMS.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleDetailController {

    @Autowired
    SaleDetailService saleDetailService;

    @PostMapping("/api/createSaleDetail")
    public ResponseEntity<String> createSaleDetail(@RequestBody SaleDetail saleDetail){
        saleDetailService.createSaleDetail(saleDetail);
        return new ResponseEntity<>("The sale detail was added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/deleteSaleDetById/{id}")
    public ResponseEntity<String> deleteSaleDetailById(@PathVariable Long id){
        if(saleDetailService.deleteSailDetailById(id) == HttpStatus.NOT_FOUND){
            return new ResponseEntity<>("Trying to delete a non existing sale detail", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Sale detail was deleted successfully", HttpStatus.OK);
        }
    }

    @PutMapping("/api/addProductToList/{saleDetId}/{prodId}")
    public ResponseEntity<String> addProductToList(@PathVariable Long saleDetId,@PathVariable Long prodId){
        if (saleDetailService.addProductToList(saleDetId, prodId) == null){
            return new ResponseEntity<>("Product or sale detail non existing", HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>("Product is added successfully", HttpStatus.ACCEPTED);
        }
    }

    @PutMapping("/api/updateSaleDetail")
    public ResponseEntity<SaleDetail> updateSaleDetail (@RequestBody SaleDetail saleDetail){
        if (saleDetailService.updateSaleDetail(saleDetail) == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(saleDetail);
        }
    }

    @GetMapping("/api/findAllSaleDet")
    public ResponseEntity<List<SaleDetail>> findAllSaleDet(){
        List<SaleDetail> saleDetailList = saleDetailService.findAllSaleDet();
        if(saleDetailList.isEmpty()){
            return new ResponseEntity<>(saleDetailList, HttpStatus.NO_CONTENT);
        }else{
            return ResponseEntity.ok(saleDetailList);
        }
    }


}
