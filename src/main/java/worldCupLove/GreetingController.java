package worldCupLove;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }

    @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue = "world!") String test) {
        return test;
    }

    @RequestMapping("/event")
    public Event event() {
        Event event = new Event("abcd", "san francisco");
        return event;
    }
}
