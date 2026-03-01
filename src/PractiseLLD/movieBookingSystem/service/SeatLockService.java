package PractiseLLD.movieBookingSystem.service;

import PractiseLLD.movieBookingSystem.enums.SeatStatus;
import PractiseLLD.movieBookingSystem.model.Seat;
import PractiseLLD.movieBookingSystem.model.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SeatLockService {
    private final Map<Long,Map<Long,List<Seat>>> lockedSeats = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private static final long LOCK_TIMEOUT_MS = 1500;

    public void lockSeats(long userId, Show show, List<Seat> seats) {
        Map<Long, List<Seat>> seatsMap = lockedSeats.computeIfAbsent(show.getId(),k -> new ConcurrentHashMap<>());

        for(Seat seat : seats){
            synchronized (seat){
                if (seat.getStatus() != SeatStatus.AVAILABLE) {
                    System.out.println("Seat " + seat.getId() + " not available");
                    return;
                }

                seat.setStatus(SeatStatus.LOCKED);

                seatsMap.computeIfAbsent(userId,k -> new ArrayList<>()).add(seat);
            }
        }

        scheduledExecutorService.schedule(
                () -> unlockSeats(userId, show, seats),
                LOCK_TIMEOUT_MS,
                TimeUnit.MILLISECONDS
        );

        System.out.println(
                "Locked seats " +
                        seats.stream().map(Seat::getId).toList() +
                        " for user " + userId
        );
    }

    public void unlockSeats(Long userId, Show show, List<Seat> seats) {

        Map<Long, List<Seat>> showLocks = lockedSeats.get(show.getId());

        if (showLocks == null) return;

        List<Seat> userSeats = showLocks.get(userId);

        if (userSeats == null) return;

        for (Seat seat : seats) {

            synchronized (seat) {

                if (seat.getStatus() == SeatStatus.LOCKED) {

                    seat.setStatus(SeatStatus.AVAILABLE);
                    userSeats.remove(seat);
                }
            }
        }

        if (userSeats.isEmpty()) {
            showLocks.remove(userId);
        }

        if (showLocks.isEmpty()) {
            lockedSeats.remove(show.getId());
        }
    }

    public void bookLockedSeats(Long userId, Show show) {

        Map<Long, List<Seat>> showLocks = lockedSeats.get(show.getId());

        if (showLocks == null) return;

        List<Seat> userSeats = showLocks.get(userId);

        if (userSeats == null) return;

        for (Seat seat : userSeats) {

            synchronized (seat) {
                seat.setStatus(SeatStatus.BOOKED);
            }
        }

        showLocks.remove(userId);
    }

    public void shutdown() {
        System.out.println("Shutting down SeatLockProvider scheduler.");
        scheduledExecutorService.shutdown();
        try {
            if (!scheduledExecutorService.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
