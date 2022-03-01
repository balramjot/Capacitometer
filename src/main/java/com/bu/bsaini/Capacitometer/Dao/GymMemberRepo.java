package com.bu.bsaini.Capacitometer.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bu.bsaini.Capacitometer.Models.GymMember;

@Repository
public interface GymMemberRepo extends JpaRepository<GymMember, Integer> {

}
