package com.standard_project.service;

import com.standard_project.model.entities.Client;

/***
 * @Janderson Coutinho
 *
 * */

public interface ClientService {
    Iterable<Client>findAll();
    Client findByID(Long id);
    void insert(Client client);
    void update(Long id,Client client);
    void delete(Long id);

}
