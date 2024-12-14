package com.emabrkx.FirstJobApp.job;

import org.springframework.data.jpa.repository.JpaRepository;

// Long indicates that the primary key is Long
public interface JobRepository extends JpaRepository<Job, Long> {
}
