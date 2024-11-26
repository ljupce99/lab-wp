package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Artist;


import java.util.List;
public interface ArtistService {

    public Artist findById(Long id);

    public List<Artist> listArtists();
}
