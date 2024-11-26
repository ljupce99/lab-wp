package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Album;
import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.model.Song;
import mk.ukim.finki.lab.repository.ArtistRepository;
import mk.ukim.finki.lab.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceInt implements SongService{
    private final SongRepository songRepo;
    private final ArtistRepository artistRepo;

    public SongServiceInt(SongRepository songRepo, ArtistRepository artistRepo) {
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
    }
    @Override
    public String saveSong(Long id,Album album, String number, String title, String rock, int releaseYear){
        if(id==null){
            id=(long)Math.random()*1000;
            Song s = new Song(id,number, title, rock, releaseYear);
            s.setAlbum(album);
            songRepo.save(s);
            return "";
        }else {
            Song s=songRepo.findById(id);
            s.setAlbum(album);
            s.setTitle(title);
            s.setGenre(rock);
            s.setTrackId(number);
            s.setReleaseYear(releaseYear);
            return "";
        }
    }

    @Override
    public String delete(Long id) {
        songRepo.delete(id);
        return "";
    }

    @Override
    public List<Song> listSongs() {
        return songRepo.findAll();
    }
    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepo.addArtistToSong(artist, song);
    }
    @Override
    public Song findByTrackId(String trackId) {
        return songRepo.findByTrackId(trackId);
    }

    @Override
    public Song findById(Long Id) {
        return songRepo.findById(Id);
    }
}
