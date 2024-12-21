package mk.ukim.finki.lab.web.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.model.Reviews;
import mk.ukim.finki.lab.model.Song;
import mk.ukim.finki.lab.service.ArtistService;
import mk.ukim.finki.lab.service.SongService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@org.springframework.stereotype.Controller
public class DetailsController {
    private final SongService songService;
    private final ArtistService artistService;



    public DetailsController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }


    @PostMapping("/Details")
    public String detailsServlet(@RequestParam("artistId") String ArtisID,Model model,HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println(ArtisID);
//        System.out.println(req.getSession().getAttribute("idtrack").toString());

        Artist artist=artistService.findById(Long.parseLong(ArtisID));

        Long TrackID=(Long) req.getSession().getAttribute("idtrack");
        Song song=songService.findById(TrackID);

        if(!song.getPerformers().contains(artist)) {
            songService.addArtistToSong(artist,TrackID);
        }

        song=songService.findById(TrackID);
        //int brojac = songService.brojac(song.getId());
        //System.out.println("noviot brojac sto dava greska"+brojac);
        List<Reviews> list=songService.listAllRew(TrackID);
        model.addAttribute("koment",list);

        model.addAttribute("bro",songService.brojac(song.getId()));

        model.addAttribute("song", song);
        return "songDetails";
    }
    @PostMapping("/addcomment")
    public String AddCom(@RequestParam String text,Model model,HttpServletRequest req, HttpServletResponse resp){
        Long TrackID=(Long) req.getSession().getAttribute("idtrack");
        Song song=songService.findById(TrackID);

//        System.out.println(text);
        songService.addCom(song.getId(), text);

        model.addAttribute("bro",songService.brojac(song.getId()));
        List<Reviews> list=songService.listAllRew(TrackID);
        model.addAttribute("koment",list);

        model.addAttribute("song", song);

        return "songDetails";
    }

}
