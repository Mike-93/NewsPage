package NewsPageApp.service;

import NewsPageApp.models.NewsType;
import NewsPageApp.repositories.NewsTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NewsTypeService {

    @Autowired
    private final NewsTypeRepository newsTypeRepository;

    public void addNewsType(String name, String color) {
        NewsType newsType = new NewsType();
        newsType.setName(name);
        newsType.setColor(color);
        newsTypeRepository.save(newsType);
    }

    public NewsType getNewsType(int id) {
        NewsType newsType = newsTypeRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
        return newsType;
    }

    public void editNewsType(int id, String name, String color) {
        NewsType newsType = newsTypeRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
        newsType.setName(name);
        newsType.setColor(color);
        newsTypeRepository.save(newsType);
    }

    public void deleteNewsType(int id) {
        newsTypeRepository.deleteById(id);
    }

    public List<NewsType> getAllNewsType() {
        Iterable<NewsType> newsTypes = newsTypeRepository.findAll();
        List<NewsType> newsTypeList = new ArrayList<>();
        for (NewsType type : newsTypes) {
            newsTypeList.add(type);
        }
        return newsTypeList;
    }

}

