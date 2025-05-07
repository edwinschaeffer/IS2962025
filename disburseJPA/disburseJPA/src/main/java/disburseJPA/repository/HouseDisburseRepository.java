package disburseJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import disburseJPA.vo.HouseDisburseDetail;

public interface HouseDisburseRepository extends JpaRepository <HouseDisburseDetail, Integer> {

	List<HouseDisburseDetail> findByYear(String year);
}
