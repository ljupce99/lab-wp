package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Album album;


    int brpjac=0;
    String trackId;
    String title;
    String genre;
    int releaseYear;

    @ManyToMany
    List<Artist> performers=new ArrayList<Artist>();

    public Song(String number, String title, String rock, int releaseYear) {
        this.trackId = number;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = rock;
    }
    public int brojac_update(){
        brpjac++;
        return brpjac;
    }


    public void addPerformer(Artist artist) {
        performers.add(artist);
    }
}
