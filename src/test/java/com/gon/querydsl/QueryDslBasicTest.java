package com.gon.querydsl;

import com.gon.querydsl.entity.Member;
import com.gon.querydsl.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class QueryDslBasicTest {

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    public void before() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @DisplayName("")
    @Test
    public void test01() throws Exception {
     //member1
        Member findResult = em.createQuery("select m from Member m " +
                                                "where m.username=:username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();
        System.out.println("findResult = " + findResult);
        assertThat(findResult).isEqualTo("member1");


    }

    @DisplayName("")
    @Test
    public void test012() throws Exception {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);


    }


}
