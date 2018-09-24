package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spitter.data.ISpitterRepository;
import spitter.data.SpitterRepository;
import spitter.data.model.Spitter;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/spitter")
public class SpitterController {

    @Autowired
    public SpitterController(ISpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    private ISpitterRepository spitterRepository;

    @RequestMapping(path="/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(path="/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid Spitter spitter,
            Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        /*
        word redirect:/url suggests, that View resolver won't create such a view, but request should be redirected.
         */
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(path = "/{spitterUsername}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable(name="spitterUsername") String spitterUsername,
            Model model) {
        model.addAttribute("spitter", spitterRepository.findUserByUsername(spitterUsername));
        return "spitter";
    }
}
