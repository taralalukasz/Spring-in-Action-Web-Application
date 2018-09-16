package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spitter.data.ISpittleRepository;
import spitter.data.model.Spittle;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="/spittles")
public class SpittleController {

    private ISpittleRepository repository;

    @Autowired
    public SpittleController (ISpittleRepository repository) {
        this.repository=repository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String findSpittles(Model model) {
//        model.addAttribute("spittleList", repository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

    /**
     * Attribute key is the same as attribute value type.
     * Repository.findSpittles return List<Spittle> - this automatically calls a model attribute as "spittleList" .
     */
//    @RequestMapping(method = RequestMethod.GET)
//    public String findSpittles(Model model) {
//        model.addAttribute(repository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

    /**
     * We can use {@link Map} instead of {@link Model} and effect will be the same as above.
     * @param model
     * @return
     */
//    @RequestMapping(method=RequestMethod.GET)
//    public String spittles(Map model) {
//        model.put("spittleList",  repository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

    /**
     * If method  with @RequestMapping annotation doesn't return String with the name of View to be rendered,
     * view Resolver tries to find a view with the same name as the method (spittles).
     * Returned value is passed to the View as model parameter (in this case spittleList, explained above why so).
     *
     * @return
     */
    @RequestMapping(method=RequestMethod.GET)
    public List<Spittle> spittles() {
        return repository.findSpittles(Long.MAX_VALUE, 20);
    }
}
