package com.cinemaapp.backend.entitys;

public class TicketWithProjection {
    private String ticketType;
    private String projectionType;
    private Float price;

    public TicketWithProjection() {
    }

    public TicketWithProjection(String ticketType, String projectionType, Integer price) {
        this.ticketType = ticketType;
        this.projectionType = projectionType;
        this.price = price.floatValue();
    }

    public TicketWithProjection(String ticketType, String projectionType, Float price) {
        this.ticketType = ticketType;
        this.projectionType = projectionType;
        this.price = price;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getProjectionType() {
        return projectionType;
    }

    public void setProjectionType(String projectionType) {
        this.projectionType = projectionType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
