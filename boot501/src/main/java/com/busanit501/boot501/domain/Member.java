package com.busanit501.boot501.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "roleSet")
public class Member extends  BaseEntity {
    @Id
    private String mid;

    private String mpw;
    private String email;
    private boolean del;

    private boolean social;

    //이미지 파일명 필요해서,
    // 프로필 이미지 조회시 사용.
    private String uuid;
    private String fileName;
    // 소셜 로그인한 프로필 이미지, 미디어 서버 주소
    private String profileImageServer;

    // 멤버를 조회시 roleSet 를 같이 조회를 하기.
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    // 세터 대신에, 임의의 멤버의 필드를 교체하는 메서드 만들기 => set 랑 비슷함.
    public void changePassword(String mpw) {
        this.mpw = mpw;
    }
    public void changeEmail(String email) {
        this.email = email;
    }
    public void changeDel(boolean del) {
        this.del = del;
    }
    public void addRole(MemberRole memberRole) {
        this.roleSet.add(memberRole);

    }
    public void clearRole() {
        this.roleSet.clear();
    }

    public void changeSocial(boolean social) {
        this.social = social;
    }

    public void changeUuidFileName(String uuid, String fileName) {
        this.uuid = uuid;
        this.fileName = fileName;
    }

}
