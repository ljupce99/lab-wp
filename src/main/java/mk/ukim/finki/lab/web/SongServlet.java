//package mk.ukim.finki.lab.web;
//
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.model.Song;
//import mk.ukim.finki.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.awt.*;
//import java.io.IOException;
//import java.util.List;
//
//
//@WebServlet(urlPatterns = "/listSongs")
//public class SongServlet extends HttpServlet {
//
//    private final SongService songService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//
//    public SongServlet(SongService songService, SpringTemplateEngine springTemplateEngine) {
//        this.songService = songService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        System.out.println(req.getSession().getId());
//        ServletConfig servletConfig = getServletConfig();
//
//
//        String sch= req.getParameter("search");
//        //System.out.println(sch);
//        List<Song> listaSongs=songService.listSongs();
//
//        if(sch!=null){
//            System.out.println(sch);
//            listaSongs= listaSongs.stream().filter(i->i.getTitle().toUpperCase().contains(sch.toUpperCase())).toList();
//        }
//
//        context.setVariable("songs",listaSongs);
//
//        springTemplateEngine.process("listSongs.html", context, resp.getWriter());
//
//
//    }
//}
