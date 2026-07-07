package com.thms.tenthouse.returns.repository;

import com.thms.tenthouse.returns.entity.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Long> {

}
