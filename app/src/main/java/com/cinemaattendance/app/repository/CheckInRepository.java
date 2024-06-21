package com.cinemaattendance.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemaattendance.app.domain.CheckIn;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long>{}
