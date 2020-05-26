package wooteco.subway.domain.member;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import wooteco.subway.domain.favorite.Favorite;

public interface MemberRepository extends CrudRepository<Member, Long> {
	@Query("select * from member where email = :email")
	Optional<Member> findByEmail(@Param("email") String email);

	@Modifying
	@Query("DELETE FROM favorite where id = :id")
	void deleteFavoriteById(@Param("id") Long favoriteId);

	@Query("SELECT * FROM favorite WHERE id = :id")
    Optional<Favorite> findFavoriteById(@Param("id") Long favoriteId);
}
