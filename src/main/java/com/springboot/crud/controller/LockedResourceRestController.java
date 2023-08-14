package com.springboot.crud.controller;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.entities.Reservation;
import com.springboot.crud.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RestController
@RequiredArgsConstructor
public class LockedResourceRestController {

	private final LockRegistry lockRegistry;
	private final ReservationRepository reservationRepository;

	@SneakyThrows
	@GetMapping("/updateLock/{id}/{name}/{time}")
	Reservation update(@PathVariable Integer id, @PathVariable String name, @PathVariable Long time) {
		String key = Integer.toString(id);
		Lock lock = lockRegistry.obtain(key);
		boolean lockAcquired = lock.tryLock(1, TimeUnit.SECONDS);
		if (lockAcquired) {
			try {
				doUpdateFor(id, name);
				Thread.sleep(time);
			} finally {
				lock.unlock();
			}
		}
		return reservationRepository.findById(id).get();
	}

	private void doUpdateFor(Integer id, String name) {
		reservationRepository.findById(id).ifPresent(res -> {
			res.setName(name);
			reservationRepository.update(res);
		});
	}
}
