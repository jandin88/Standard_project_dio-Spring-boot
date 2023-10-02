package com.standard_project.service.impl;

import com.standard_project.model.entities.Address;
import com.standard_project.model.entities.Client;
import com.standard_project.model.repository.AddressRepository;
import com.standard_project.model.repository.ClientRepository;
import com.standard_project.service.CepService;
import com.standard_project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceIml implements ClientService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CepService cepService;
    @Override
    public Iterable<Client> findAll() {
        //FIXME busca todos clientes
        return clientRepository.findAll();
    }

    @Override
    public Client findByID(Long id) {
        Optional<Client> client=clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientToCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clienteBd = clientRepository.findById(id);
        if (clienteBd.isPresent()) {
            saveClientToCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientToCep(Client client) {
        String cep= client.getAddress().getCep();
        Address address=addressRepository.findById(cep).orElseGet(()-> {
            Address newAddress= cepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }


}
