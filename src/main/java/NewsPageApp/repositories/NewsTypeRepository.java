package NewsPageApp.repositories;

import NewsPageApp.models.NewsType;
import org.springframework.data.repository.CrudRepository;

public interface NewsTypeRepository extends CrudRepository <NewsType, Integer> {
}
