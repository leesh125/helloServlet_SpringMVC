package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 테스트 끝나고 테스트를 초기화 하기 위해
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("hello", 20); // 새 멤버 생성

        // when
        Member savedMember = memberRepository.save(member); // 생성한 멤버 저장하기

        //then
        Member findMember = memberRepository.findById(savedMember.getId()); // 저장된 멤버의 아이디로 멤버 찾기
        assertThat(findMember).isEqualTo(savedMember); // 찾은 멤버와 저장된 멤버가 같은 멤버 객체인지 테스트
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll(); // 멤버 리포지토리에 있는 멤버들을 리스트 객체로 생성

        // then
        assertThat(result.size()).isEqualTo(2); // 리스트 객체의 사이즈가 2와 같은지
        assertThat(result).contains(member1,member2); // 리스트 객체에 생성한 멤버들이 포함 되었는지
    }
}
