package com.veiuper.restful.service;

import com.veiuper.restful.model.Client;
import com.veiuper.restful.repository.CrudInMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final CrudInMemoryRepository<Client> crudInMemoryRepository;

    public ClientServiceImpl(CrudInMemoryRepository<Client> crudInMemoryRepository) {
        this.crudInMemoryRepository = crudInMemoryRepository;
    }

    @Override
    public void create(Client client) {
        crudInMemoryRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
        return crudInMemoryRepository.findAll();
    }

    @Override
    public Optional<Client> read(long id) {
        return crudInMemoryRepository.findById(id);
    }

    @Override
    public boolean update(Client client) {
        return crudInMemoryRepository.update(client);
    }

    @Override
    public boolean delete(long id) {
        return crudInMemoryRepository.deleteById(id);
    }
}
