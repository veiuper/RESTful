package com.veiuper.restful.repository;

import com.veiuper.restful.model.Client;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClientRepository implements CrudInMemoryRepository<Client> {
    // Customer Storage
    private static final ConcurrentHashMap<Long, Client> CLIENT_REPOSITORY_MAP = new ConcurrentHashMap<>();
    // Variable for generating the client ID
    private static final AtomicLong CLIENT_ID_HOLDER = new AtomicLong();

    @Override
    public void save(Client client) {
        final long clientId = CLIENT_ID_HOLDER.getAndIncrement();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public boolean update(Client client) {
        if (CLIENT_REPOSITORY_MAP.containsKey(client.getId())) {
            CLIENT_REPOSITORY_MAP.put(client.getId(), client);
            return true;
        }
        return false;
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Optional<Client> findById(long id) {
        Client client = CLIENT_REPOSITORY_MAP.get(id);
        if (client == null) {
            return Optional.empty();
        }
        return Optional.of(client);
    }

    @Override
    public boolean deleteById(long id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            CLIENT_REPOSITORY_MAP.remove(id);
            return true;
        }
        return false;
    }
}
