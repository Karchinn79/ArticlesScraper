package karchinn79.xyz.SpaceflightNews.DAO;

import karchinn79.xyz.SpaceflightNews.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesDAO extends JpaRepository<Article, Integer> {
}
