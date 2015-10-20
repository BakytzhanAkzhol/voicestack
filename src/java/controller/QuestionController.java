/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.Impl.*;
import java.sql.SQLException;
import model.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import util.HibernateUtil;

/**
 *
 * @author bako
 */
@Controller
public class QuestionController {

    QuestionController mainController;

    public QuestionController() {
    }

    public QuestionController(QuestionController mainController) {
        this.mainController = mainController;
    }

    @RequestMapping("/question/index.htm")
    public ModelAndView index(Model model) throws SQLException {
        ModelAndView mv;
        mv = new ModelAndView("question/index");
        QuestionDAOImpl modul = new QuestionDAOImpl();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Question.class);
        mv.addObject("list", cr.list());
        return mv;
    }

    @RequestMapping(value = "/question/create.htm", method = RequestMethod.GET)
    public String registrate(Model model) throws SQLException {
        model.addAttribute("create", new Question());
        return "question/create";
    }

    @RequestMapping(value = "/question/create.htm", method = RequestMethod.POST)
    public String registrate2(@ModelAttribute("create") Question question) throws SQLException {
        QuestionDAOImpl modul = new QuestionDAOImpl();
        question = modul.create(question);
        return "redirect:/question/" + question.getId() + "/view";
    }

    @RequestMapping(value = "/question/{id}/view.htm", method = RequestMethod.GET)
    public ModelAndView viewQuestion(@PathVariable(value = "id") String id) throws SQLException {
        QuestionDAOImpl modul = new QuestionDAOImpl();
        Question question = modul.findById(id);
        ModelAndView model = new ModelAndView("question/view");
        model.addObject("element", question);
        model.addObject("root_link", "http://localhost:8084/VoiceStack/");
        return model;
    }

    @RequestMapping(value = "/question/{id}/update.htm", method = RequestMethod.GET)
    public ModelAndView updateQuestion(@PathVariable(value = "id") String id) throws SQLException {
        QuestionDAOImpl modul = new QuestionDAOImpl();
        Question question = modul.findById(id);
        ModelAndView model = new ModelAndView("question/update");
        model.addObject("root_link", "http://localhost:8084/VoiceStack/");
        model.addObject("element", question);
        return model;
    }

    @RequestMapping(value = "/question/{id}/update.htm", method = RequestMethod.POST)
    public String updateQuestionSubmit(@PathVariable(value = "id") String id, @ModelAttribute("question") Question question) throws SQLException {
        QuestionDAOImpl modul = new QuestionDAOImpl();
        Question question2 = modul.update(question);
        return "redirect:/question/" + question2.getId() + "/view.htm";
    }

    @RequestMapping(value = "/question/{id}/remove.htm", method = RequestMethod.POST)
    public String removeQuestion(@PathVariable(value = "id") String id, @ModelAttribute("registration") User user) throws SQLException {
        UserDAOImpl modul = new UserDAOImpl();
        modul.remove(user);
        return "redirect:/question/index.htm";
    }
}
