package com.interview.practice.Interfaces;

import com.interview.practice.CommonEnum.RoomType;
import com.interview.practice.Domain.DateRange;
import com.interview.practice.Domain.RoomInventory;

import java.time.LocalDate;
import java.util.List;

public interface IRoomInventoryRepository {

    void save(
            RoomInventory inventory
    );

    RoomInventory findByKey(
            String hotelId,
            RoomType roomType,
            LocalDate date
    );

    List<RoomInventory>
    findByDateRange(
            String hotelId,
            RoomType roomType,
            DateRange dateRange
    );

    void saveAll(
            List<RoomInventory> inventories
    );
}
