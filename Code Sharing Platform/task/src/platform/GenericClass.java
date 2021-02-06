package platform;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericClass {
    private String code;
    private String date;
    //private String content;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String title;

    public GenericClass(){
        // default constructor
    }

    public GenericClass(String title, String code, String date) {
        this.title = title;
        this.code = code;
        this.date = date;
        //this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*public String getContent() {
        return content;
    }*/

    /*public void setContent(String content){
        this.content = content;
    }*/

}
