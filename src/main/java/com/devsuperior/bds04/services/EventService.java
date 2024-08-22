package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    public Page<EventDTO> findAll(Pageable pageable) {

        Page<Event> result = eventRepository.findAll(pageable);

        return result.map(event -> new EventDTO(event));
    }

    public EventDTO insert(EventDTO dto) {

        Event event = new Event();
        event.setCity(new City());
        copyDtoToEntity(dto, event);
        event = eventRepository.save(event);
        return new EventDTO(event);
    }

    private void copyDtoToEntity(EventDTO dto, Event entity){

        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.getCity().setId(dto.getCityId());
    }


}