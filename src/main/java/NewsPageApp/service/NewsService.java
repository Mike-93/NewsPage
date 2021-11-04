package NewsPageApp.service;

import NewsPageApp.models.News;
import NewsPageApp.models.NewsType;
import NewsPageApp.repositories.NewsRepository;
import NewsPageApp.repositories.NewsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsTypeRepository newsTypeRepository;

    public void addNews(int id, String name, String shortDesc, String fullDesc, int typeId) {
        NewsType newsType = newsTypeRepository.findById(typeId).orElseThrow(() -> new NoSuchElementException(""));
        News news = new News();
        news.setId(id);
        news.setName(name);
        news.setShortDesc(shortDesc);
        news.setFullDesc(fullDesc);
        news.setType(newsType);
        newsRepository.save(news);
    }

    public List<News> getAllNews() {
        Iterable<News> news = newsRepository.findAll();
        List<News> newsList = new ArrayList<>();
        for (News n : news) {
            newsList.add(n);
        }
        return newsList;
    }

    public News getNews(int id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
        return news;
    }

    public void editNews(int id, String name, String shortDesc, String fullDesc, int typeId) {
        NewsType newsType = newsTypeRepository.findById(typeId).orElseThrow(() -> new NoSuchElementException(""));
        News news = newsRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
        news.setName(name);
        news.setShortDesc(shortDesc);
        news.setFullDesc(fullDesc);
        news.setType(newsType);
        newsRepository.save(news);
    }

    public void deleteNews(int id) {
        newsRepository.deleteById(id);
    }

    public List<News> getNewsByNewsType(int typeId) {
        NewsType newsType = newsTypeRepository.findById(typeId).orElseThrow(() -> new NoSuchElementException(""));
        Iterable<News> news = newsRepository.findAll();
        List<News> newsList = new ArrayList<>();
        for (News n : news) {
            if (n.getType().equals(newsType)) {
                newsList.add(n);
            }
        }
        return newsList;
    }
}
