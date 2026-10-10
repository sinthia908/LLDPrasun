package com.interview.practice.Domain;

import com.interview.practice.CommonEnum.RoomType;

import java.time.LocalDate;

public class RoomInventory {

        private final String hotelId;

        private final RoomType roomType;

        private final LocalDate date;

        private final int totalRooms;

        private int heldRooms;

        private int bookedRooms;

        public RoomInventory(
                String hotelId,
                RoomType roomType,
                LocalDate date,
                int totalRooms
        ) {
            this.hotelId = hotelId;
            this.roomType = roomType;
            this.date = date;
            this.totalRooms = totalRooms;
        }

        public int getAvailableRooms() {

            return totalRooms
                    - heldRooms
                    - bookedRooms;
        }

        public void holdRooms(
                int roomCount
        ) {

            if (getAvailableRooms()
                    < roomCount) {

                throw new RuntimeException(
                        "Rooms are not available"
                );
            }

            heldRooms += roomCount;
        }

        public void confirmRooms(
                int roomCount
        ) {

            if (heldRooms < roomCount) {

                throw new IllegalStateException(
                        "Invalid room hold"
                );
            }

            heldRooms -= roomCount;

            bookedRooms += roomCount;
        }

        public void releaseRooms(
                int roomCount
        ) {

            if (heldRooms < roomCount) {

                throw new IllegalStateException(
                        "Invalid room release"
                );
            }

            heldRooms -= roomCount;
        }

        public LocalDate getDate() {
            return date;
        }
    }

