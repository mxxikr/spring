package com.mxxikr.spring_basic.core.member;

import java.util.HashMap;
import java.util.Map;

// 저장소
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    // 동시성 이슈 고려 X, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); // store.put(key, value)
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}