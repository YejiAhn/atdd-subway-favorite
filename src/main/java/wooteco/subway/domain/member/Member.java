package wooteco.subway.domain.member;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import wooteco.subway.domain.favorite.Favorite;

public class Member {
    Set<Favorite> favorites = new HashSet<>();
    @Id
    private Long id;
    private String email;
    private String name;
    private String password;

    public Member() {
    }

    public Member(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Member(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public void update(String name, String password) {
        if (StringUtils.isNotBlank(name)) {
            this.name = name;
        }
        if (StringUtils.isNotBlank(password)) {
            this.password = password;
        }
    }

    public void addFavorite(Favorite favorite) {
        favorites.add(favorite);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean doesNotHaveFavoriteWithId(Long favoriteId) {
        return favorites.stream()
            .noneMatch(favorite -> favorite.getId().equals(favoriteId));
    }

    public Long getId() {
        return id;
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

    public Set<Favorite> getFavorites() {
        return favorites;
    }
}
