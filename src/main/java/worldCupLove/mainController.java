package worldCupLove;

import entity.Item;
import external.ExternalAPI;
import external.WorldCupAPI;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ComponentScan("external")
@ComponentScan("entity")
public class mainController {

    //test code 1
    @RequestMapping("/greeting1")
    public String greeting1(Model model) {
        model.addAttribute("name", "hello");
        return "greeting";
    }

    //test code 2
    @RequestMapping("/greeting2")
    public String greeting2() {
        return "index";
    }

    //test code 3
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    //get bean from spring container
    @Autowired
    private ExternalAPI api;

    @Autowired
    private Item item;

    @GetMapping("/matches")
    public String matches(@RequestParam(name="name", required = false, defaultValue = "") String name, Model model) {
        // Get info from API
        api.queryAPI("matches");
        JSONArray matches = api.request("matches");

        //There should be some saveItem logic here


        model.addAttribute("matches", matches);
        return "matches.html";
    }


}
