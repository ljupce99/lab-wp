package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImp implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImp(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
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
