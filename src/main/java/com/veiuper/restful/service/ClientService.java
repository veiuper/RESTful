package com.veiuper.restful.service;

import com.veiuper.restful.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    /**
     * Creates a new client
     * @param client client to create
     */
    void create(Client client);

    /**
     * Returns a list of all available clients
     *
     * @return list of clients
     */
    List<Client> readAll();

    /**
     * Returns the client by its ID
     * @param id client ID
     *
     * @return Returns an {@link Optional} description for the client
     */
    Optional<Client> read(long id);

    /**
     * Updates the client with the specified ID, according to the transmitted client
     * @param client the client according to which the data needs to be updated
     * @param id ID of the client to update
     *
     * @return {@code true} if the data has been updated, otherwise {@code false}
     */
    boolean update(Client client, long id);

    /**
     * Deletes a client with the specified ID
     * @param id ID of the client to delete
     *
     * @return {@code true} if the client was deleted, otherwise {@code false}
     */
    boolean delete(long id);
}
