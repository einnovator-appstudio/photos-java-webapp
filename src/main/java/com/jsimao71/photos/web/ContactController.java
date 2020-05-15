package com.jsimao71.photos.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import com.jsimao71.photos.manager.ContactManager;
import com.jsimao71.photos.model.Contact;
import com.jsimao71.photos.repository.ContactRepository;
import com.jsimao71.photos.xmodel.ContactFilter;
import com.jsimao71.photos.xmodel.ContactOptions;
import java.util.Collection;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.einnovator.jpa.manager.ManagerBase;
import org.einnovator.jpa.manager.ManagerBaseImpl;
import org.einnovator.util.PageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping(value = { "/contact" })
public class ContactController extends ControllerBase {

    @Autowired()
    private ContactManager contactManager;

    @GetMapping(value = { "/{id}" })
    public Object show(@PathVariable(value = "id") String id, ContactOptions options, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        model.addAttribute("contact", contactManager.find(id, options));
        return "contact/contact-details";
    }

    @GetMapping(value = {})
    public Object list(ContactFilter filter, PageOptions pageOptions, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        model.addAttribute("contacts", contactManager.findAll(filter, pageOptions));
        return "contact/contact-list";
    }

    @GetMapping(value = { "/create" })
    public Object create(Contact contact, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
    }

    @PostMapping(value = {})
    public Object createPost(Contact contact, BindingResult errors, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        contactManager.create(contact);
        return "redirect:/";
    }

    @GetMapping(value = { "/{id}/edit" })
    public Object edit(@PathVariable(value = "id") String id, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
    }

    @PutMapping(value = { "/{id}" })
    public Object editPost(@PathVariable(value = "id") String id, Contact contact, BindingResult errors, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        contactManager.update(contact);
        return "redirect:/contact/" + id;
    }

    @DeleteMapping(value = { "/{id}" })
    public Object delete(@PathVariable(value = "id") String id, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        contactManager.delete(id);
        return "redirect:/contact";
    }

    @ExceptionHandler(value = {})
    public Object error(@PathVariable(value = "exception") Exception exception, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        return "redirect:/contact";
    }
}
