package com.carelly.demo.service;

import java.util.List;

import com.carelly.demo.dto.ProblemaDto;
public interface IProblemaService {
    public ProblemaDto create(ProblemaDto problema);
    public ProblemaDto get(Long id);
    public void delete(Long id);
    public List<ProblemaDto> getAll();
}
