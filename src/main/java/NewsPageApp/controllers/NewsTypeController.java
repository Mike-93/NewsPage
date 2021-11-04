package NewsPageApp.controllers;

import NewsPageApp.service.NewsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NewsTypeController {

    private final NewsTypeService newsTypeService;

    @PostMapping("/news-types/addNewsType")
    public String addNewsType(@RequestParam String name, @RequestParam String color) {
        newsTypeService.addNewsType(name, color);
        return "redirect:/";
    }

    @PutMapping("/news-type/{id}/edit")
    public String editNewsType(@PathVariable int id, @RequestParam String name, @RequestParam String color) {
        newsTypeService.editNewsType(id, name, color);
        return "redirect:/";
    }

    @DeleteMapping("/news-type/{id}/remove")
    public String newsTypeRemove(@PathVariable int id) {
        newsTypeService.deleteNewsType(id);
        return "redirect:/";
    }

    @GetMapping("/news-types")
    public String getAllNewsTypes() {
        newsTypeService.getAllNewsType();
        return "news-types";
    }

    @GetMapping("/news-types/{id}")
    public String getNewsType (@PathVariable int id){
        newsTypeService.getNewsType(id);
        return "news-type";
    }

//    @GetMapping ("/news-types/")

}
