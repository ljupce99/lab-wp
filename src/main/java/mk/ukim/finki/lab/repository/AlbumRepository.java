package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public interface AlbumRepository extends JpaRepository<Album, Long> {
//    public AlbumRepository() {
//        this.albums.add( new Album( 1l,"Thriller", "Pop", "1982"));
//        this.albums.add( new Album(2l,"Back in Black", "Rock", "1980"));
//        this.albums.add( new Album( 3l,"The Dark Side of the Moon", "Progressive Rock", "1973"));
//        this.albums.add( new Album( 4l,"Rumours", "Soft Rock", "1977"));
//        this.albums.add( new Album(5l,"Abbey Road", "Rock", "1969"));
//    }
//
//    private List<Album> albums=new ArrayList<>();
//
//    public List<Album> findAll(){
//        return albums;
//    }
//    public Album findById(Long id){
//        return albums.stream().filter(album -> album.getId().equals(id)).findFirst().orElse(null);
//    }
}
