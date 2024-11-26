package mk.ukim.finki.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@AllArgsConstructor
//@NoArgsConstructor
public class Album {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;

    public Album(String thriller, String pop, String number) {
    }
}
