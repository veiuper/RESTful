package com.veiuper.restful.service;

import com.veiuper.restful.model.Client;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClientServiceImpl implements ClientService {
    // Customer Storage
    private static final Map<Long, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();
    // Variable for generating the client ID
    private static final AtomicLong CLIENT_ID_HOLDER = new AtomicLong();

    @Override
    public void create(Client client) {
        final long clientId = CLIENT_ID_HOLDER.getAndIncrement();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Optional<Client> read(long id) {
        Client client = CLIENT_REPOSITORY_MAP.get(id);
        if (client == null) {
            return Optional.empty();
        }
        return Optional.of(client);
    }

    @Override
    public boolean update(Client client, long id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            CLIENT_REPOSITORY_MAP.remove(id);
            return true;
        }
        return false;
    }
}
