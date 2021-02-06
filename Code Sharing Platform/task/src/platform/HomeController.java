package platform;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HomeController {

    private final String titleData = "Code";
    private final String code_data = "public static void main(String[] args) {\\n    SpringApplication.run(CodeSharingPlatform.class, args);\\n}";

    private final GenericClass gc = new GenericClass(titleData, code_data);

    public HomeController(){

    }

    @RequestMapping(path = "/api/code", produces = "application/json;charset=UTF-8")
    public GenericClass getApiCode(){
        return gc;
    }

    @RequestMapping(path = "/code", produces = "text/html")
    public ResponseEntity<String> getHtmlCode(){
        return ResponseEntity.ok().body("<title>" + gc.getTitle() + "</title>\n" + "<pre>" + gc.getCode()                                     + "</pre>");
    }
}