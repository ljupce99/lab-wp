package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Album;
import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.model.Song;
import mk.ukim.finki.lab.repository.ArtistRepository;
import mk.ukim.finki.lab.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SongServiceInt implements SongService{
    private final SongRepository songRepo;
    private final ArtistRepository artistRepo;

    public SongServiceInt(SongRepository songRepo, ArtistRepository artistRepo) {
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
        List<Song> listaS=new ArrayList<>();
        listaS.add(new Song( null,"T001", "Billie Jean", "Pop", 1982));
        listaS.add(new Song( null,"T002", "Hells Bells", "Rock", 1980));
        listaS.add(new Song(null, "T003", "Money", "Progressive Rock", 1973));
        listaS.add(new Song(null, "T004", "Dreams", "Soft Rock", 1977));
        listaS.add(new Song(null, "T005", "Come Together", "Rock", 1969));

        listaS.stream().forEach(s->songRepo.save(s));
    }
    @Override
    public String saveSong(Long id,Album album, String number, String title, String rock, int releaseYear){
        if(id==null){
            Song s = new Song(album,number, title, rock, releaseYear);
            songRepo.save(s);
            return "";
        }else {
            Song s=songRepo.getReferenceById(id);
            s.setAlbum(album);
            s.setTitle(title);
            s.setGenre(rock);
            s.setTrackId(number);
            s.setReleaseYear(releaseYear);
            songRepo.save(s);
            return "";
        }
    }

    @Override
    public String delete(Long id) {
        Song s=songRepo.getReferenceById(id);
        songRepo.delete(s);
        return "";
    }

    @Override
    public List<Song> listSongs() {
        return songRepo.findAll();
    }
    @Override
    public Artist addArtistToSong(Artist artist, Long song) {
        Song s=songRepo.getReferenceById(song);
//        songRepo.delete(s);
        s.addPerformer(artist);
        songRepo.save(s);
        return artist;
    }
    @Override
    public Song findByTrackId(String trackId) {
        return songRepo.findAll().stream().filter(s->s.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    @Override
    public Song findById(Long Id) {
        return songRepo.findById(Id).orElse(null);
    }

    @Override
    public int brojac(Long id) {
        Song song=songRepo.getReferenceById(id);
        System.out.println(song.toString());
        int brojac=song.getBrpjac();
        brojac++;
        song.setBrpjac(brojac);
        songRepo.save(song);

        return brojac;
    }
}
