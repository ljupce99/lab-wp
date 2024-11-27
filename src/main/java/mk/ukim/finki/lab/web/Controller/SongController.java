package mk.ukim.finki.lab.web.Controller;

import mk.ukim.finki.lab.model.Album;
import mk.ukim.finki.lab.model.Song;
import mk.ukim.finki.lab.service.AlbumService;
import mk.ukim.finki.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SongController {
    final SongService songService;
    final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String search ,@RequestParam(required = false) String error, Model model){
        List<Song> lista=songService.listSongs();
        System.out.println(search);
        if(search!=null){
            lista=lista.stream().filter(i->i.getTitle().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
        }
        model.addAttribute("songs",lista);
        model.addAttribute("flag", false);
        return "listSongs";
    }
//--------------------------------------------------------------------------------------------------------------------------------------------


    @GetMapping("/songs/add")
    public String saveSong(Model model){
        model.addAttribute("albums",albumService.findAll());
        model.addAttribute("flag",true);
        return "add-song";
    }
    @PostMapping("/songs/add-form")
    public String getAddSongPage(@RequestParam String num, @RequestParam String title, @RequestParam String genre, @RequestParam int year, @RequestParam(required = false) Long album, Model model){
//        System.out.println(num);
//        System.out.println(title);
//        System.out.println(genre);
//        System.out.println(year);
        Album al = null;
        if(album!=null){
            al=albumService.findById(album);
        }

        

        Long id=null;
        songService.saveSong(id,al,num,title,genre,year);

        return "redirect:/songs";
    }
//-----------------------------------------------------------------------------------------------------------------------------------------


    @GetMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model){
        System.out.println("idto "+songId);
        Song song=songService.findById(songId);
        model.addAttribute("ong",song);
        model.addAttribute("albums",albumService.findAll());
        model.addAttribute("flag", false);

        return "add-song";
    }
    @PostMapping("/songs/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id,@RequestParam String num, @RequestParam String title, @RequestParam String genre, @RequestParam int year, @RequestParam(required = false) Long album){
        Album al = null;
        if(album!=null){
            al=albumService.findById(album);
        }
        songService.saveSong(id,al,num,title,genre,year);
        return "redirect:/songs";
    }

//------------------------------------------------------------------------------------------------------------------------------------------

    @PostMapping("/songs/delete/{songId}")
    public String deleteSong(@PathVariable Long songId, Model model){
        songService.delete(songId);
        return "redirect:/songs";

    }
}
