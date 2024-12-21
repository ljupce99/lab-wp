package mk.ukim.finki.lab.web.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.model.Song;
import mk.ukim.finki.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ListSongsController {
    private final SongService songService;

    public ListSongsController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/listSongs")
    public String listSongs(@RequestParam(required = false) String search , Model model, HttpServletRequest req, HttpServletResponse resp) {
        List<Song> lista=songService.listSongs();
//        System.out.println(search);
        if(search!=null){
            lista=lista.stream().filter(i->i.getTitle().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
        }

        model.addAttribute("flag",true);
        model.addAttribute("songs",lista);
        return "listSongs";
    }
}
