package com.standard_project.service;

import com.standard_project.model.entities.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface CepService {

    @GetMapping("/{cep}/json/")
    Address consultCep(@PathVariable("cep") String cep);

}
