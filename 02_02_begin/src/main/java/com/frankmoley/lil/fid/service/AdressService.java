package com.frankmoley.lil.fid.service;

public class AdressService {
    private String address;

    public AdressService(String currentAdress) {
        this.address = currentAdress;
    }

    public String getAddress(){
        return this.address;
    }
}