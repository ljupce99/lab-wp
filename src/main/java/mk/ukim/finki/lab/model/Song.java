package mk.ukim.finki.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;

@Data
//@Entity
@AllArgsConstructor
//@NoArgsConstructor
public class Song {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
    private Album album;
    int brpjac=0;


    String trackId;
    String title;
    String genre;
    int releaseYear;

//    @ManyToMany
    List<Artist> performers=new ArrayList<Artist>();



    public Song(Long id,Album album,String number, String title, String rock, int releaseYear) {
        this.id = id;
        this.album = album;
        this.trackId=number;
        this.title=title;
        this.genre=rock;
        this.releaseYear=releaseYear;

    }

    public Song(String t002, String hellsBells, String rock, int i) {
        trackId = t002;
        title = hellsBells;
        genre = rock;
        releaseYear = i;
    }

    public Song(long l, String t001, String billieJean, String pop, int i) {
        id = l;
        trackId = t001;
        title = billieJean;
        genre = pop;
        releaseYear = i;

    }


    public void addPerformer(Artist artist) {
        performers.add(artist);
    }
}
