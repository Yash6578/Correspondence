package com.ashokit.correspondence.repository;

import com.ashokit.correspondence.entity.CorrespondenceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrespondenceStatusRepo extends JpaRepository<CorrespondenceDetails, Long> {
}
