package com.interview.practice.Interfaces;

import com.interview.practice.Domain.Hotel;

import java.util.Collection;

public interface IHotelRepository {

    void save(Hotel hotel);

    Hotel findById(int hotelId);

    Collection<Hotel> findAll();


}
