package com.springboot.crud.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.springboot.crud.entities.Reservation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {
	private final RowMapper<Reservation> rowMapper = (rs, i) -> new Reservation(rs.getInt("id"), rs.getString("name"));
	private final JdbcTemplate jdbcTemplate;

	public Optional<Reservation> findById(Integer id) {
		List<Reservation> reservations = jdbcTemplate.query("select * from reservation where id = ?", this.rowMapper, id);
		return reservations.isEmpty() ? Optional.empty() : Optional.ofNullable(reservations.iterator().next());
	}
	
	Collection<Reservation> findAll() {
		return jdbcTemplate.query("select * from reservation", this.rowMapper);
	}
	
	public  Reservation update(Reservation reservation) {
		Assert.isTrue((reservation.getId() != null && reservation.getId() != 0), "this id must be non - null");
		
		return jdbcTemplate.execute("update reservation where set name = ? where id = ?", (PreparedStatementCallback<Reservation>) ps -> {

				ps.setString(1, reservation.getName());
				ps.setInt(2, reservation.getId());
				ps.execute();
				return findById(reservation.getId()).get();
		});
	}

}
