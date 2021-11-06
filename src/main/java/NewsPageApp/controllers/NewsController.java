package NewsPageApp.controllers;

import NewsPageApp.models.News;
import NewsPageApp.service.NewsService;
import NewsPageApp.service.NewsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;
    private final NewsTypeService newsTypeService;

    @PostMapping("/addNews")
    public String addNews(@RequestParam String name, @RequestParam String shortDesc,
                          @RequestParam String fullDesc, @RequestParam int type) {
        newsService.addNews(name, shortDesc, fullDesc, type);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getAllNews(Model model) {
        model.addAttribute("newsType", newsTypeService.getAllNewsType());
        model.addAttribute("newsList", newsService.getAllNews());
        return "news-page";
    }

    @GetMapping("/news/{id}/edit")
    public String editNews(@PathVariable int id, Model model) {
        model.addAttribute("newsType", newsTypeService.getAllNewsType());
        model.addAttribute("news", newsService.getNews(id));
        return "news-edit";
    }

    @GetMapping("news/{id}")
    public String showNews(@PathVariable int id, Model model) {
        News news = newsService.getNews(id);
        model.addAttribute("news", news);
        return "news";
    }

    @PostMapping("/news/{id}/edit")
    public String editNews(@PathVariable int id, @RequestParam String name,
                           @RequestParam String shortDesc, @RequestParam String fullDesc, @RequestParam int type) {
        newsService.editNews(id, name, shortDesc, fullDesc, type);
        return "redirect:/";
    }

    @PostMapping("/news/{id}/remove")
    public String deleteNews(@PathVariable int id) {
        newsService.deleteNews(id);
        return "redirect:/";
    }
}
