package umc.spring.study.repository.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.enums.MemberStatus;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.status = :status")
    List<Member> findByNameAndStatus(@Param("name") String name, @Param("status") MemberStatus status);
}
