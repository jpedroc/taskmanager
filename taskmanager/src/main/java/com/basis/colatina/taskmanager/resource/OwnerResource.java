package com.basis.colatina.taskmanager.resource;

import com.basis.colatina.taskmanager.service.OwnerService;
import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
@Slf4j
public class OwnerResource {

    private final OwnerService ownerService;

    @GetMapping
    public ResponseEntity<OwnerDTO> find() {
        OwnerDTO owner = ownerService.find();
        log.info("Owner recuperado com sucesso: {}", owner.getId());
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OwnerDTO> update(@RequestBody OwnerDTO ownerDTO) {
        OwnerDTO owner = ownerService.save(ownerDTO);
        log.info("Owner alterado com sucesso: {}", owner.getId());
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }
}
