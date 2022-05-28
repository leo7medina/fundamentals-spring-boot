package ec.com.leo.dev.fundamentum.spring.boot.repository;

import ec.com.leo.dev.fundamentum.spring.boot.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Posts, Long> {
}
