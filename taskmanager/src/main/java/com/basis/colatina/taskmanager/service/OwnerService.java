package com.basis.colatina.taskmanager.service;

import com.basis.colatina.taskmanager.domain.Owner;
import com.basis.colatina.taskmanager.repository.OwnerRepository;
import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
import com.basis.colatina.taskmanager.service.exception.BadRequestAlertException;
import com.basis.colatina.taskmanager.service.mapper.OwnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public OwnerDTO save(OwnerDTO ownerDTO) {
        if (ownerDTO.getBirthDate().isAfter(LocalDate.now())) {
            throw new BadRequestAlertException("Invalid Birth Date");
        }

        Owner owner = ownerRepository.save(ownerMapper.toEntity(ownerDTO));

        return ownerMapper.toDto(owner);
    }

    public OwnerDTO find() {
        return ownerMapper.toDto(getOne(1));
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

}
