package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    private final CatalogServiceImpl catalogServiceImpl;

    @Autowired
    public CatalogController(CatalogServiceImpl catalogServiceImpl) {
        this.catalogServiceImpl = catalogServiceImpl;
    }

    @GetMapping("/{genre}")
    ResponseEntity<CatalogWS> getCatalogByGenre(@PathVariable("genre") String genre) {
        CatalogWS catalogWS = catalogServiceImpl.findByGenre(genre);
        return Objects.isNull(catalogWS)
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(catalogWS, HttpStatus.OK);
    }
}
