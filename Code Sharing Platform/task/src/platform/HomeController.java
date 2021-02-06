package platform;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HomeController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String home(){
        return "Code Sharing Platform";
    }

    @RequestMapping("/code")
    public GenericClass genericClass(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GenericClass(counter.incrementAndGet(), String.format(template, name));
    }
}