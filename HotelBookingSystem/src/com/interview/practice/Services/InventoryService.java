package com.interview.practice.Services;

import com.interview.practice.CommonEnum.RoomType;
import com.interview.practice.ConcreteLockProviders.InMemoryLockProvider;
import com.interview.practice.Domain.DateRange;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class InventoryService {

    private final InMemoryLockProvider
            lockProvider;

    private final InventoryRepository
            inventoryRepository;

    public InventoryService(
            InMemoryLockProvider lockProvider,
            InventoryRepository inventoryRepository
    ) {
        this.lockProvider = lockProvider;

        this.inventoryRepository =
                inventoryRepository;
    }

    public void createHold(
            String hotelId,
            RoomType roomType,
            DateRange dateRange,
            int roomCount
    ) {

        List<Lock> acquiredLocks =
                new ArrayList<>();

        try {

            LocalDate currentDate =
                    dateRange.getCheckIn();

            while (currentDate.isBefore(
                    dateRange.getCheckOut()
            )) {

                String inventoryKey =
                        createInventoryKey(
                                hotelId,
                                roomType,
                                currentDate
                        );

                Lock lock =
                        lockProvider.getLock(
                                inventoryKey
                        );

                lock.lock();

                acquiredLocks.add(lock);

                currentDate =
                        currentDate.plusDays(1);
            }

            reserveAllDates(
                    hotelId,
                    roomType,
                    dateRange,
                    roomCount
            );

        } finally {

            for (
                    int i =
                    acquiredLocks.size() - 1;

                    i >= 0;

                    i--
            ) {

                acquiredLocks
                        .get(i)
                        .unlock();
            }
        }
    }

    private void reserveAllDates(
            String hotelId,
            RoomType roomType,
            DateRange dateRange,
            int roomCount
    ) {

        List<RoomInventory> inventories =
                inventoryRepository
                        .findByDateRange(
                                hotelId,
                                roomType,
                                dateRange
                        );

        for (
                RoomInventory inventory
                : inventories
        ) {

            if (
                    inventory.getAvailableRooms()
                            < roomCount
            ) {

                throw new RuntimeException(
                        "Rooms unavailable"
                );
            }
        }

        for (
                RoomInventory inventory
                : inventories
        ) {

            inventory.holdRooms(
                    roomCount
            );
        }
    }

    private String createInventoryKey(
            String hotelId,
            RoomType roomType,
            LocalDate date
    ) {

        return hotelId
                + ":"
                + roomType
                + ":"
                + date;
    }
}