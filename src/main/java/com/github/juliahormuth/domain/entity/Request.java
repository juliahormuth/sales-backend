package com.github.juliahormuth.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Request {
    private Integer id;
    private Client client;
    private LocalDate dateRequest;
    private BigDecimal total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(LocalDate dateRequest) {
        this.dateRequest = dateRequest;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
