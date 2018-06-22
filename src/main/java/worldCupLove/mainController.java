package worldCupLove;

import external.WorldCupAPI;
import org.json.JSONArray;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class mainController {
    WorldCupAPI api = new WorldCupAPI();

    @RequestMapping("/greeting1")
    public String greeting1(Model model) {
        model.addAttribute("name", "hello");
        return "greeting";
    }

    @RequestMapping("/greeting2")
    public String greeting2() {
        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/matches")
    public String matches(@RequestParam(name="name", required = false, defaultValue = "") String name, Model model) {
        api.queryAPI("matches");
        JSONArray matches = api.getRequest("matches");

        model.addAttribute("matches", matches);
        return "matches.html";
    }



}
