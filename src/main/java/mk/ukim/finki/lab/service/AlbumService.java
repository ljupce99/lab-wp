package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Album;
import mk.ukim.finki.lab.repository.AlbumRepository;

import java.util.List;

public interface AlbumService {
    public List<Album> findAll();

    public Album findById(Long id);
}
