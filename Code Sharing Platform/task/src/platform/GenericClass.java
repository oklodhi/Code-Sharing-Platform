package platform;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericClass {
    private String code;
    //private String content;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String title;

    public GenericClass(){
        // default constructor
    }

    public GenericClass(String title, String code) {
        this.title = title;
        this.code = code;
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

    /*public String getContent() {
        return content;
    }*/

    /*public void setContent(String content){
        this.content = content;
    }*/

}
