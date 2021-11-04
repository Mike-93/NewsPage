package NewsPageApp.controllers;

import NewsPageApp.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PostMapping("/addNews")
    public String addNews(@RequestParam String name, @RequestParam String shortDesc,
                          @RequestParam String fullDesc, @RequestParam int typeId) {
        newsService.addNews(name, shortDesc, fullDesc, typeId);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getAllNews() {
        newsService.getAllNews();
        return "index";
    }

    @GetMapping("/{id}")
    public String showNews(@PathVariable int id) {
        newsService.getNews(id);
        return "news";
    }

    @PutMapping("/news/{id}/edit")
    public String editNews(@PathVariable int id, @RequestParam String name,
                           @RequestParam String shortDesc, @RequestParam String fullDesc, @RequestParam int typeId) {
        newsService.editNews(id, name, shortDesc, fullDesc, id);
        return "redirect:/";
    }

    @DeleteMapping("/news/{id}")
    public String deleteNews(@PathVariable int id) {
        newsService.deleteNews(id);
        return "redirect:/";
    }


}
