package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.ReservationDTO;
import com.airftn.AirFTN.model.Reservation;
import com.airftn.AirFTN.model.Ticket;
import com.airftn.AirFTN.repository.ReservationRepository;

@Service
public class ReservationService implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public List<Reservation> findAll() {

		return reservationRepository.findAllByDeletedIsFalse();
	}

	@Override
	public List<Reservation> findAllByPassengerId(Long id) {

		return reservationRepository.findAllByPassengerId(id);
	}

	@Override
	public Reservation getOne(Long id) {

		return reservationRepository.getOne(id);
	}

	@Override
	public Reservation create(ReservationDTO reservation) {

		Reservation res = new Reservation();
		res.setDeleted(false);
		res.setPassenger(reservation.getPassenger());
		res.setTickets(reservation.getTickets());
		setTicketsToOccupied(res);

		return reservationRepository.save(res);

	}

	@Override
	public Reservation update(Reservation reservation) {

		Reservation res = reservationRepository.getOne(reservation.getId());
		res.setPassenger(reservation.getPassenger());
		res.setTickets(reservation.getTickets());

		return res;
	}

	@Override
	public Reservation setTicketsToOccupied(Reservation reservation) {

		List<Ticket> tickets = reservation.getTickets();

		for (Ticket t : tickets) {
			t.getSeat().setOccupied(true);
		}

		return reservation;
	}
}
