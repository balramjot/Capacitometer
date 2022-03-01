package com.bu.bsaini.Capacitometer.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bu.bsaini.Capacitometer.Dao.GymMemberRepo;
import com.bu.bsaini.Capacitometer.Models.GymMember;

@Service
public class GymMemberService {

	@Autowired
	GymMemberRepo gymMemberRepo;
	
	public List<GymMember> getAllGymMembers() {
		return gymMemberRepo.findAll();
	}
}
