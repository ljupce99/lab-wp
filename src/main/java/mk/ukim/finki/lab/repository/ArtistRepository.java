package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Artist;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    private List<Artist> listaA=new ArrayList<>();

    public ArtistRepository() {
        listaA.add(new Artist( 1l,"Axl", "Rose", "Singer"));
        listaA.add(new Artist(2l,"Jon", "Bon Jovi", "Rockstar"));
        listaA.add(new Artist( 3l,"David", "Bowie", "Icon"));
        listaA.add(new Artist( 4l,"Freddie", "Mercury", "Legend"));
        listaA.add(new Artist( 5l,"Kurt", "Cobain", "Grunge"));
    }

    public List<Artist> findAll(){
        return listaA;
    }
    public Optional<Artist> findById(Long id){
        return listaA.stream().filter(i->i.getId().equals(id)).findFirst();
    }
}
