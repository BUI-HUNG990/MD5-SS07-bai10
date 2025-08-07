package ra.exercise.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.exercise.model.entity.Movie;
import ra.exercise.model.service.MovieService;

import java.util.Optional;

@Controller
@RequestMapping(value = {"/", "movieController"})
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String showMovie(Model model) {

        model.addAttribute("movies", movieService.getAllMovies());
        return "movieList";
    }

    @GetMapping("/goToAddPage")
    public String goToAddPage(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "addMovie";
    }

    @PostMapping("/addMovie")
    public String addMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult,  Model model) {
        if (bindingResult.hasErrors()) {
            return "addMovie";
        }
        if(movieService.addMovie(movie)) {
            model.addAttribute("movies", movieService.getAllMovies());
            model.addAttribute("message", "thêm phim thành công");
            return "movieList";
        }
        model.addAttribute("error", "có lỗi vui lòng thử lại");
        return "addMovie";
    }

    @GetMapping("/goToUpdatePage")
    public String goToUpdatePage(@RequestParam("id") Integer id, Model model) {
        Optional<Movie> movie = movieService.getMovie(id);
        if (movie.isEmpty()) {
            model.addAttribute("error", "lấy id sản pẩm lỗi");
            return "movieList";
        }
        model.addAttribute("movie", movie.get());
        return "updateMovie";
    }

    @PostMapping("/updateMovie")
    public String updateMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult,  Model model) {
        if (bindingResult.hasErrors()) {
            return "updateMovie";
        }
        if(movieService.updateMovie(movie)) {
            model.addAttribute("movies", movieService.getAllMovies());
            model.addAttribute("message", "sửa phim thành công");
            return "movieList";
        }
        model.addAttribute("error", "có lỗi vui lòng thử lại");
        return "updateMovie";
    }

    @GetMapping("/deleteMovie")
    public String deleteMovie( @RequestParam("id") Integer id,  Model model) {
        if(movieService.deleteMovie(id)) {
            model.addAttribute("movies", movieService.getAllMovies());
            model.addAttribute("message", "xóa phim thành công");
            return "movieList";
        } else {
            model.addAttribute("error", "có lỗi vui lòng thử lại");
        }
        return "movieList";
    }
}
