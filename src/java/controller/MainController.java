/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author bako
 */
@Controller
public class MainController {
    MainController mainController;

    public MainController() {
    
    }
    
    public MainController(MainController mainController) {
        this.mainController=mainController;
    }
    @RequestMapping("/login.htm")
    public ModelAndView login(Model model) throws SQLException{
        ModelAndView mv;
        mv = new ModelAndView("login");
        return mv;
    }
    
}
