package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Album;
import mk.ukim.finki.lab.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    final AlbumRepository albumRepository ;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
        List<Album> albums = new ArrayList<>();
        albums.add( new Album( "Thriller", "Pop", "1982"));
        albums.add( new Album("Back in Black", "Rock", "1980"));
        albums.add( new Album( "The Dark Side of the Moon", "Progressive Rock", "1973"));
        albums.add( new Album( "Rumours", "Soft Rock", "1977"));
        albums.add( new Album("Abbey Road", "Rock", "1969"));
        albumRepository.saveAll(albums);
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).get();
    }
}
