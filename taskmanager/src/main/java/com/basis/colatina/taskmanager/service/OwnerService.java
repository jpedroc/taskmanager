package com.basis.colatina.taskmanager.service;

import com.basis.colatina.taskmanager.domain.Owner;
import com.basis.colatina.taskmanager.repository.OwnerRepository;
import com.basis.colatina.taskmanager.repository.elastic.OwnerSearchRepository;
import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
import com.basis.colatina.taskmanager.service.dto.listing.OwnerListDTO;
import com.basis.colatina.taskmanager.service.elastic.OwnerElasticsearchService;
import com.basis.colatina.taskmanager.service.event.OwnerEvent;
import com.basis.colatina.taskmanager.service.exception.BadRequestAlertException;
import com.basis.colatina.taskmanager.service.filter.OwnerFilter;
import com.basis.colatina.taskmanager.service.mapper.OwnerListMapper;
import com.basis.colatina.taskmanager.service.mapper.OwnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final OwnerSearchRepository ownerSearchRepository;
    private final OwnerListMapper ownerListMapper;

    public OwnerDTO save(OwnerDTO ownerDTO) {
        if (ownerDTO.getBirthDate().isAfter(LocalDate.now())) {
            throw new BadRequestAlertException("Invalid Birth Date");
        }

        Owner owner = ownerRepository.save(ownerMapper.toEntity(ownerDTO));
        applicationEventPublisher.publishEvent(new OwnerEvent(owner.getId()));

        return ownerMapper.toDto(owner);
    }

    public List<OwnerDTO> find() {
        return ownerMapper.toDto(ownerRepository.findAll());
    }

    public OwnerDTO findOne(Integer id) {
        return ownerMapper.toDto(getOne(id));
    }

    public void delete(Integer id) {
        Owner owner = getOne(id);
        ownerRepository.delete(owner);
    }

    private Owner getOne(Integer id) {
        return ownerRepository.findById(id).orElseThrow(() -> new BadRequestAlertException("Owner not found"));
    }

    public Page<OwnerListDTO> search(OwnerFilter filter, Pageable pageable) {
        return ownerSearchRepository.search(filter.getFilter(), pageable).map(ownerListMapper::toDto);
    }

}

