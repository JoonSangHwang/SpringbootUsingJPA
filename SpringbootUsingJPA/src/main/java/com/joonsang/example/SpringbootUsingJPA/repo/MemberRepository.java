package com.joonsang.example.SpringbootUsingJPA.repo;

import com.joonsang.example.SpringbootUsingJPA.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * << 메소드 이름으로 쿼리 생성1 >>
     * - 선택한 유저 그리고 age 초과 값 구하기
     * - WHERE username = :username AND age > :age
     *
     * 참고
     * - https://docs.spring.io/spring-data/jpa/docs/2.3.6.RELEASE/reference/html/#jpa.query-methods
     * - 이 기능은 엔티티의 필드명이 변경되면 인터페이스에 정의한 메서드 이름도 꼭 함께 변경해야 한다.
     */
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    /**
     * << 메소드 이름으로 쿼리 생성2 >>
     * - 유저 전체 조회
     */
    List<Member> find_________________________By();

    /**
     * << @Query, 리포지토리 메소드에 쿼리 정의하기 >>
     * - 유저 조회
     */
    @Query("select m from Member m where m.username= :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
}
