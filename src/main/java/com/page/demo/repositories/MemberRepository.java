package com.page.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.page.demo.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


}
