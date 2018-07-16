package com.projects.webfluxcrud.handlers;

import com.projects.webfluxcrud.models.ClientModel;
import com.projects.webfluxcrud.repositories.ReactiveClientRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClientHandler {

    private final ReactiveClientRepository reactiveClientRepository;

    public ClientHandler (ReactiveClientRepository reactiveClientRepository) {
        this.reactiveClientRepository = reactiveClientRepository;
    }

    public Mono<ServerResponse> getAllClients(ServerRequest request) {
        Iterable<ClientModel> clients = this.reactiveClientRepository.findAll();

        System.out.println("\n\n========");
        System.out.println(clients);
        System.out.println("========\n\n");

        return ServerResponse.ok().body(BodyInserters.fromObject("Getting ALL clients..."));
    }

    public Mono<ServerResponse> getClientById(ServerRequest request) {

        String id = request.pathVariable("id");
        System.out.println("\n=====> ID: " + id + "\n\n");

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Getting client by id..."));
    }
}
