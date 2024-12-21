package mk.ukim.finki.lab.web.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.model.Song;
import mk.ukim.finki.lab.service.ArtistService;
import mk.ukim.finki.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtistController {
    private final SongService songService;
    private final ArtistService artistService;

    public ArtistController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @PostMapping("/artist")
    public String artistServlet(@RequestParam(value = "trackId",required = false) Long TrackId, Model model, HttpServletRequest req, HttpServletResponse resp) {
        model.addAttribute("artists", artistService.listArtists());
        Song song=songService.findById(TrackId);
        model.addAttribute("idtrack", song.getTrackId());

        req.getSession().setAttribute("idtrack", TrackId);

        return "artistsList";
    }
}
