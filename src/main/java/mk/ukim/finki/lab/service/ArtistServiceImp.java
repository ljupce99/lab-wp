package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistServiceImp implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImp(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
        List<Artist> listaA=new ArrayList<>();
        listaA.add(new Artist( "Axl", "Rose", "Singer"));
        listaA.add(new Artist("Jon", "Bon Jovi", "Rockstar"));
        listaA.add(new Artist( "David", "Bowie", "Icon"));
        listaA.add(new Artist( "Freddie", "Mercury", "Legend"));
        listaA.add(new Artist( "Kurt", "Cobain", "Grunge"));
        artistRepository.saveAll(listaA);
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).get();
    }
    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }
}
