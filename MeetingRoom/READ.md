Problem Statement:

1> Given (n) meeting rooms. Users can book any meeting room from (start time to end time) if the room is available.
2> If a room is not available, it should be shown at that moment only.
3> All the participants of a meeting should receive a notification related to the same.
4> Use the calendar for tracking dates and times.
5> Store the history of all the meetings scheduled.
6> Users can see all the available meeting rooms for a particular time slot ( can be neglected for implementation but is good to discuss)



Design a concurrent, overlap-safe meeting room booking system, handling:
Time-slot conflicts
Parallel booking requests
Clean & extensible object-oriented design


// 

User
→ createReservation()
→ lock rooms
→ confirmReservation()
→ validate lock
→ payment
→ confirm
→ unlock rooms