package com.bu.bsaini.Capacitometer.Dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bu.bsaini.Capacitometer.Models.Timesheet;

@Repository
public interface TimesheetRepo extends JpaRepository<Timesheet, Integer> {
	
	@Query("select t from Timesheet t WHERE t.gymMember.id = ?1 and t.status = '1' and cast(t.checkInTime as date) = CURDATE()")
	List<Timesheet> checkIfUserIsAlreadyCheckedIn(int memberId);
	
	@Query("select t from Timesheet t WHERE t.gymMember.id = ?1 ORDER BY t.checkInTime DESC")
	List<Timesheet> findByTimesheetGymMemberIdOrderByCheckInTimeDesc(int memberId);
	
	Integer countByStatus(int status);
	
	@Query("select new com.bu.bsaini.Capacitometer.Models.Timesheet(count(*), MONTHNAME(t.checkInTime), YEAR(t.checkInTime)) from Timesheet t WHERE t.checkInTime BETWEEN ?1 AND ?2 GROUP BY MONTH(t.checkInTime)")
	List<Timesheet> findCapacityLogsByDate(LocalDateTime from, LocalDateTime to);
}
