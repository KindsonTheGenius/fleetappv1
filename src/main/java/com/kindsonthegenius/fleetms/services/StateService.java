package com.kindsonthegenius.fleetms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetms.models.State;
import com.kindsonthegenius.fleetms.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	//Get All States
	public List<State> findAll(){
		return stateRepository.findAll();
	}	
	
	//Get State By Id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}	
	
	//Delete State
	public void delete(int id) {
		stateRepository.deleteById(id);
	}
	
	//Update State
	public void save( State state) {
		stateRepository.save(state);
	}
}
