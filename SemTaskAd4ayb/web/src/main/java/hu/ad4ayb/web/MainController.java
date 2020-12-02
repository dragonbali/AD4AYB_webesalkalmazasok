package hu.ad4ayb.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.ad4ayb.web.serv.ListingService;


@Controller
public class MainController {

    @Autowired
    private ListingService listingService;

    @GetMapping("/")
    public String getTeacherPage() {
        return "teacher";
    }

    int counter = 0;
    @GetMapping("/all")
    public ModelAndView showAll() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("students", listingService.getStudents());
        mav.addObject("isOkList", listingService.isOkList(listingService.getStudents()));
        mav.setViewName("all");
        return mav;
    }

    @RequestMapping(value = "all", params = "index", method = RequestMethod.POST)
    public ModelAndView listAllStudents(int index) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("details");
        mav.addObject("student", listingService.getStudents().get(index));
        return mav;
    }

}