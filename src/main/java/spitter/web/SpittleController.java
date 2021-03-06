package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spitter.data.ISpittleRepository;
import spitter.data.model.Spittle;

import java.util.List;
import java.util.Map;

@Controller
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

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
    @RequestMapping(method=RequestMethod.GET, path="/spittles")
    public List<Spittle> spittles(
            @RequestParam(defaultValue = MAX_LONG_AS_STRING, name="max") long max,
            @RequestParam(defaultValue = "20", name="count") int count) {
        return repository.findSpittles(max, count);
    }


    /**
     * if Path variable name is the same as method parameter name, it is not necessary to write the name in annotation.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/spittles/show/{spittleId}")
    public String showSpittle(
            @PathVariable long spittleId,
            Model model) {
        model.addAttribute("spittle", repository.findOne(spittleId) );
        return "spittle";
    }

    /**
     * You can also pass the name of path variable in annotation parameter
     */
//    @RequestMapping(method = RequestMethod.GET, path = "/spittles/show/{spittleId}")
//    public String showSpittle(
//            @PathVariable("spittleId") long spittleId,
//            Model model) {
//        model.addAttribute("spittle", repository.findOne(spittleId) );
//        return "spittle";
//    }
}
