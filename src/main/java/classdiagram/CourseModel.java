/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdiagram;

/**
 *
 * @author fitexmage
 */
public class CourseModel {

    private int id;
    private String name;
    private int level;
    private int required;
    private String url;

    public CourseModel(int id, String name, int level, int required, String url) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.required = required;
        this.url = url;
    }

    public CourseModel() {

    }

    public String requiredToString() {
        switch (required) {
            case (0):
                return "Not required";
            case (1):
                return "Required";
            case (2):
                return "Optional Required";
        }
        return "";
    }



    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the required
     */
    public int getRequired() {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(int required) {
        this.required = required;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
