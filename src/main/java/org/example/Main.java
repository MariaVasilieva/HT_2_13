package org.example;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        // Створення сервісів
        TicketCrudService ticketCrudService = new TicketCrudService();
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        // Додавання тестових даних
        Client client = clientCrudService.getClient(11L)
                .orElseGet(()->{
                    Client newClient = new Client();
                    newClient.setName("John Doe");
                    clientCrudService.createClient(newClient);
                    return newClient;
                });

        Planet fromPlanet = planetCrudService.getPlanet("EARTH")
                .orElseGet(() -> {
                    Planet newPlanet = new Planet("EARTH", "Earth");
                    planetCrudService.createPlanet(newPlanet);
                    return newPlanet;
                });

        Planet toPlanet = planetCrudService.getPlanet("MARS")
                .orElseGet(() -> {
                    Planet newPlanet = new Planet("MARS", "Mars");
                    planetCrudService.createPlanet(newPlanet);
                    return newPlanet;
                });
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // Створення квитка
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(timestamp);
        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);
        ticketCrudService.createTicket(ticket);

        // Перевірка існуючого квитка
        Ticket fetchedTicket = ticketCrudService.getTicket(ticket.getId());
        System.out.println("Fetched Ticket: " + fetchedTicket.getId() + ", " +
                fetchedTicket.getClient().getName() + " from " +
                fetchedTicket.getFromPlanet().getName() + " to " +
                fetchedTicket.getToPlanet().getName());

        // Оновлення квитка
        Planet newToPlanet = planetCrudService.getPlanet("Ven")
                .orElseGet(() -> {
                    Planet newPlanet = new Planet("Ven", "Venus");
                    planetCrudService.createPlanet(newPlanet);
                    return newPlanet;
                });
        ticket.setToPlanet(newToPlanet);
        ticketCrudService.updateTicket(ticket);

        // Видалення квитка
        ticketCrudService.deleteTicket(ticket.getId());
        Ticket deletedTicket = ticketCrudService.getTicket(ticket.getId());
        System.out.println("Deleted Ticket: " + (deletedTicket == null ? "Not found" : "Found"));

    }
}