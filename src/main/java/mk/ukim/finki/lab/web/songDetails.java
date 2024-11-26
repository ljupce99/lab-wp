//package mk.ukim.finki.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.model.Artist;
//import mk.ukim.finki.lab.model.Song;
//import mk.ukim.finki.lab.service.ArtistService;
//import mk.ukim.finki.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet("/Details")
//public class songDetails extends HttpServlet {
//    private final ArtistService artistService;
//    private final SongService songService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public songDetails(ArtistService artistService, SongService songService, SpringTemplateEngine springTemplateEngine) {
//        this.artistService = artistService;
//        this.songService = songService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//
//        String TID = (String) req.getParameter("track");
//        Long AID = Long.valueOf(req.getParameter("artistId"));
//
//
//        WebContext context = new WebContext(webExchange);
//
//        Artist artist=artistService.findById(AID);
//        Song song=songService.findByTrackId(TID);
//        System.out.println(artist.toString());
//        System.out.println(song.toString());
//
//        if(!song.getPerformers().contains(artist)) {
//            songService.addArtistToSong(artist,song);
//        }
//
//        song=songService.findByTrackId(TID);
//        context.setVariable("song",song);
//
//        springTemplateEngine.process("songDetails.html", context, resp.getWriter());
//
//
//
//
//
//    }
//}
