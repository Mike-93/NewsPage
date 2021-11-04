package NewsPageApp.repositories;

import NewsPageApp.models.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository <News, Integer> {
}
