package com.alkemy.java.service;
import java.util.List;

import com.alkemy.java.model.Activities;
import com.alkemy.java.repository.ActivitiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alkemy.java.dto.ActivitiesDto;

@Service
public interface ActivitiesService {

    @Autowired
    ActivitiesRepository activitiesRepository;

    ResponseEntity<?> createActivity(ActivitiesDto activity);
    public List< ActivitiesDto> getAll();
	public ActivitiesDto getById(Long id) throws Exception;
    void updateActivities(Long id, ActivitiesDto activity) throws Exception;

    Activities findById(Long id);
}
