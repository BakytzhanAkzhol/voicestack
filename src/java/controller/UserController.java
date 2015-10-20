/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.Impl.UserDAOImpl;
import DAO.UserDAO;
import com.mysql.jdbc.SQLError;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bako
 */
@Controller
public class UserController {

    private final String SESSION_USER = "userSession";
    UserController mainController;

    public UserController() {
    }

    public UserController(UserController mainController) {
        this.mainController = mainController;
    }

    @RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
    public ModelAndView login(Model model,HttpSession session) throws SQLException {
        if(session.getAttribute(SESSION_USER)!=null){
            return new ModelAndView("redirect:/user/index.htm");
        }
        model.addAttribute("login", new User());
        ModelAndView modul = new ModelAndView("user/login");
        return modul;
    }

    @RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
    public ModelAndView loginSubmit(
            @ModelAttribute("login") User user,
            HttpSession session
            ) throws SQLException {
//        model.addAttribute("login", new User()); 
        ModelAndView model=null;
        UserDAOImpl modul = new UserDAOImpl();
        User userAuth = modul.authority(user);
        if (userAuth != null) {
            session.setAttribute(SESSION_USER, user);
            return new ModelAndView("redirect:/user/index.htm");
        } else {
            model = new ModelAndView("user/fail");
            model.addObject("Password",user.md5(user.getPassword_hash()));
            return model;
        }
    }

    @RequestMapping("/user/index.htm")
    public ModelAndView list(Model model, HttpServletRequest request) throws SQLException {

        if (request.getSession().getAttribute(SESSION_USER) == null) {
                return new ModelAndView("redirect:login.htm");
        } else {
            ModelAndView mv = new ModelAndView("user/index");
            UserDAO modul = new UserDAOImpl();
            mv.addObject(SESSION_USER,(User)request.getSession().getAttribute(SESSION_USER));
            mv.addObject("list", modul.getAll());
            return mv;
        }
    }

    @RequestMapping(value = "/user/registrate.htm", method = RequestMethod.GET)
    public String registrate(Model model) throws SQLException {
        model.addAttribute("registration", new User());
        return "user/registrate";
    }

    @RequestMapping(value = "/user/registrate.htm", method = RequestMethod.POST)
    public String registrate2(@ModelAttribute("registration") User user) throws SQLException {
        UserDAOImpl modul = new UserDAOImpl();
        user = modul.create(user);
        return "redirect:/user/" + user.getId() + "/view.htm";
    }

    @RequestMapping(value = "/user/{id}/view.htm", method = RequestMethod.GET)
    public ModelAndView viewUser(@PathVariable(value = "id") String id) throws SQLException {
        UserDAOImpl modul = new UserDAOImpl();
        User user;
        user = modul.findById(id);
        ModelAndView model = new ModelAndView("user/view");
        model.addObject("user", user);
        model.addObject("root_link", "http://localhost:8084/VoiceStack/");
        return model;
    }

    @RequestMapping(value = "/user/{id}/update.htm", method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable(value = "id") String id) throws SQLException {
        UserDAOImpl modul = new UserDAOImpl();
        User user;
        user = modul.findById(id);
        ModelAndView model = new ModelAndView("user/update");
        model.addObject("root_link", "http://localhost:8084/VoiceStack/");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/user/{id}/update.htm", method = RequestMethod.POST)
    public String updateUserSubmit(@PathVariable(value = "id") String id, @ModelAttribute("user") User user) throws SQLException {
        UserDAOImpl modul = new UserDAOImpl();
        User user2 = modul.update(user);
        return "redirect:/user/" + user2.getId() + "/view.htm";
    }

    @RequestMapping(value = "/user/{id}/remove.htm", method = RequestMethod.POST)
    public String removeUser(@PathVariable(value = "id") String id, @ModelAttribute("registration") User user) throws SQLException {
        UserDAOImpl modul = new UserDAOImpl();
        modul.remove(user);
        return "redirect:/user/index.htm";
    }
}
