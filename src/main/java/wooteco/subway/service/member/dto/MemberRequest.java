package wooteco.subway.service.member.dto;

import wooteco.subway.domain.member.Member;

public class MemberRequest {
    private String email;
    private String name;
    private String password;

    public Member toMember() {
        return new Member(email, name, password);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
