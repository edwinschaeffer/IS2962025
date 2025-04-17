package disburseJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import disburseJPA.vo.HouseDisburseDetail;

public interface HouseDisburseRepository extends JpaRepository <HouseDisburseDetail, Integer> {

}
