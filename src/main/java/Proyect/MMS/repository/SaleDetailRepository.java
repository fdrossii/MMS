package Proyect.MMS.repository;

import Proyect.MMS.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepository extends JpaRepository <SaleDetail, Long> {
}
