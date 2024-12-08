package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Album;
import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.model.Song;

import java.util.List;

public interface SongService {
    public List<Song> listSongs();

    public Artist addArtistToSong(Artist artist, Long song);

    public Song findByTrackId(String trackId);
    public String saveSong(Long id,Album album, String number, String title, String rock, int releaseYear);

    public String delete( Long id);
    public Song findById(Long Id);
    public int brojac(Long id);

}
