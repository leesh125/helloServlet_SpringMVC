package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }


    private MemberRepository() {

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        // store에 있는 값들을 불러와 새로운 ArrayList에 담는다
        // 이유 : ArrayList에 값을 밖에서 조작해도 기존 store의 값들은 건들지 않기 위해
        return new ArrayList<>(store.values());
    }

    // store 안에 값 다 날리기
    public void clearStore(){
        store.clear();
    }
}
