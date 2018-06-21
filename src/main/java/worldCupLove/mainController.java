package worldCupLove;

import external.WorldCupAPI;
import org.json.JSONArray;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {

    public static final String API_ENDPOINT = "https://worldcup.sfg.io";
    public static final String TEAMS = "https://worldcup.sfg.io/teams";
    public static final String MATCHES = "https://worldcup.sfg.io/matches";
    public static final String MATCHES_TODAY = "https://worldcup.sfg.io/matches/today";
    public static final String MATCHES_TOMORROW = "https://worldcup.sfg.io/matches/tomorrow";

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

    @GetMapping("/teams")
    public String teams() {

    }

    private JSONArray request(String URL) {
        return 
    }
}
