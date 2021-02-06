package platform;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@RestController
public class HomeController {

    private final String title_data = "Code";
    private final String code_data = "public static void main(String[] args) {\\n    SpringApplication.run(CodeSharingPlatform.class, args);\\n}";

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private final String date_data = dtf.format(LocalDateTime.now());

    private final GenericClass gc = new GenericClass(title_data, code_data, date_data);

    public HomeController(){

    }

    @GetMapping(path = "/api/code", produces = "application/json;charset=UTF-8")
    public GenericClass getApiCode(){
        return gc;
    }

    @GetMapping(path = "/code", produces = "text/html")
    public ResponseEntity<String> getHtmlCode(){
        return ResponseEntity.ok().body(
                "<span id=\"load_date\">" + gc.getDate() + "</span>\n" +
                "<title>" + gc.getTitle() + "</title>\n" +
                "<pre id=\"code_snippet\">" + gc.getCode() + "</pre>");
    }

    @PostMapping(path = "/api/code/new", produces = "application/json;charset=UTF-8")
    public String postApiCodeNew(@RequestBody GenericClass gc1){
        gc.setDate(date_data);
        gc.setTitle("Code");
        gc.setCode(gc1.getCode());

        return "{}";
    }

    @GetMapping(path = "/code/new", produces = "text/html")
    public ResponseEntity<String> getHtmlCodeNew(){
        return ResponseEntity.ok().body(
                "<span id=\"load_date\">" + date_data + "</span>\n" +
                "<title>Create</title>\n" +
                "<div>" +
                "<textarea id=\"code_snippet\">Write Code Here</textarea>" +
                "<div>" +
                "<button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>" +
                "</div>" +
                "<script type=\"text/javascript\">\n" +
                "function send() {\n" +
                "    let object = {\n" +
                "        \"code\": document.getElementById(\"code_snippet\").value\n" +
                "    };\n" +
                "    \n" +
                "    let json = JSON.stringify(object);\n" +
                "    \n" +
                "    let xhr = new XMLHttpRequest();\n" +
                "    xhr.open(\"POST\", '/api/code/new', false)\n" +
                "    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');\n" +
                "    xhr.send(json);\n" +
                "    \n" +
                "    if (xhr.status == 200) {\n" +
                "      alert(\"Success!\");\n" +
                "    }\n" +
                "}</script>" +
                "</div>");
    }
}