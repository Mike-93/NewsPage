package NewsPageApp.service;

import NewsPageApp.models.News;
import NewsPageApp.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public void addNews (News news) {
        newsRepository.save(news);
    }
//    getNews
//    editNews
//    deleteNews
//    getAllNews
//    getNewsByNewsType
}
