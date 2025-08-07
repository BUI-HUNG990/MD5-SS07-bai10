package ra.exercise.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Movie {
    private Integer id;

    @NotBlank(message = "tên phim không để trống")
    @Size(max = 100, message = "tên phim có độ dài 100 ký tự")
    private String title;

    @NotBlank(message = "tên đạo diễm không để trống")
    @Size(max = 50, message = "tên đạo diễm có độ dài 50 ký tự")
    private String director;

    @NotNull(message = "ngày phát hành không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotBlank(message = "thể loại phim không được để trống")
    @Size(max = 30, message = "độ dài 30 ký tự")
    private String genre;

    @NotBlank(message = "Poster không được để trống")
    private String poster;

    public Movie(Integer id, String title, String director, LocalDate releaseDate, String genre, String poster) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.poster = poster;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
