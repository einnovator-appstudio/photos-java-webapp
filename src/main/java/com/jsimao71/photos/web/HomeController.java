package com.jsimao71.photos.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Collection;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.einnovator.util.PageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping(value = { "/" })
public class HomeController extends ControllerBase {

    @GetMapping(value = { "/" })
    public Object home(Contact contact, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        model.addAttribute("_admin", roleManager.hasRole("ADMIN"));
        return "Home";
    }
}
