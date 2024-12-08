package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private String releaseYear;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    public Album(String backInBlack, String rock, String number) {
        this.name = backInBlack;
        this.genre = rock;
        this.releaseYear = number;

    }
}
