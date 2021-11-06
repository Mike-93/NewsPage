package NewsPageApp.controllers;

import NewsPageApp.service.NewsService;
import NewsPageApp.service.NewsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class NewsTypeController {

    private final NewsTypeService newsTypeService;
    private final NewsService newsService;

    @PostMapping("/news-types/addNewsType")
    public String addNewsType(@RequestParam String name, @RequestParam String color) {
        newsTypeService.addNewsType(name, color);
        return "redirect:/";
    }

    @PostMapping("/news-type/{id}/edit")
    public String editNewsType(@PathVariable int id, @RequestParam String name, @RequestParam String color) {
        newsTypeService.editNewsType(id, name, color);
        return "redirect:/";
    }

    @PostMapping("/news-type/{id}/remove")
    public String newsTypeRemove(@PathVariable int id) {
        newsTypeService.deleteNewsType(id);
        return "redirect:/";
    }

    @GetMapping("/news-types")
    public String getAllNewsTypes(Model model) {
        model.addAttribute("newsType", newsTypeService.getAllNewsType());
        return "news-types";
    }

    @GetMapping("/news-type/{id}/edit")
    public String editNewsType(@PathVariable int id, Model model) {
        model.addAttribute("newsType", newsTypeService.getNewsType(id));
        return "news-type-edit";
    }

    @GetMapping("/news-type/{id}/list")
    public String getNewsByType(@PathVariable int id, Model model) {
        model.addAttribute("newsType", newsTypeService.getNewsType(id));
        model.addAttribute("newsList", newsService.getNewsByNewsType(id));
        return "news-by-type";
    }

}
