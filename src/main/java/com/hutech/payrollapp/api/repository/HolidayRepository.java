package com.hutech.payrollapp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
	
	@Query(value = "select * from holiday_list r where r.calendar_region=:calendarRegion", nativeQuery = true)
	public List<Holiday> findByCalendarRegion(String calendarRegion);
}
