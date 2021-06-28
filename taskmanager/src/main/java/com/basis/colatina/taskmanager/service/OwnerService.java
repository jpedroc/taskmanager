package com.basis.colatina.taskmanager.service;

import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerService {

    public OwnerDTO save(OwnerDTO ownerDTO) {
        return null;
    }

    public OwnerDTO findOne(Integer id) {
        return null;
    }

    public void delete(Integer id) {}

}
