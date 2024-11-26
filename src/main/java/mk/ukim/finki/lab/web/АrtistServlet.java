//package mk.ukim.finki.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.service.ArtistService;
//import mk.ukim.finki.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet("/artist")
//public class АrtistServlet extends HttpServlet {
//    private final ArtistService artistService;
//    private final SongService songService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public АrtistServlet(ArtistService artistService, SongService songService, SpringTemplateEngine springTemplateEngine) {
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
//        WebContext context = new WebContext(webExchange);
//        String TID= req.getParameter("trackId");
//
//        context.setVariable("artists",artistService.listArtists());
//        System.out.println(TID);
//        context.setVariable("idtrack",TID);
//
//        springTemplateEngine.process("artistsList.html", context, resp.getWriter());
//    }
//}
