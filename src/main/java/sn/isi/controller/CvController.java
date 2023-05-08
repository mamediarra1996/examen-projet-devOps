package sn.isi.controller;


import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sn.isi.entity.CV;
import sn.isi.service.CvService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CvController {

    private CvService cvService;

    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping(value = "/")
    public String index() {

        return "inscription/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        CV cv = new CV();
        model.addAttribute("cv", new CV());
        return "inscription/add";

    }
    @GetMapping("/login")
    public String login(){
        return "inscription/login";
    }

    @PostMapping(value = "/inscription")
    public String save(CV cv, Model model) {
        model.addAttribute("cv",new CV());
        System.out.println(cv.getEmail());
        cvService.save(cv);
        return "inscription/add";
    }

    @GetMapping(value = "/list")
    public String listCV(Model model) {
        model.addAttribute("cv", cvService.listCV());
        return "inscription/all";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        CV cv = cvService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid professeur Id:" + id));
        model.addAttribute("cv", cv);
        return "inscription/edit";
    }
    @PostMapping("/update/{id}")
    public String updateCv(@PathVariable("id") Long id, @Validated CV cv, BindingResult result, Model model) {
        cvService.save(cv);
        return "inscription/all";
    }
    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable("id") Long id, Model model) {
        CV cv = cvService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid inscription Id:" + id));
        cv.delete(cv);
        return "inscription/all";
    }
    @GetMapping("/logout")
    public String logout (HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }
}



