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
public class LinkModel {
    private String source;
    private String target;
    private int relationship; //1:and 2:or
    
    public LinkModel(String source, String target, int relationship){
        this.source = source;
        this.target = target;
        this.relationship = relationship;
    }
    
    public LinkModel(){
        
    }
    
    public String relationshipToString(){
        switch (relationship) {
            case (1):
                return "AND";
            case (2):
                return "OR";
        }
        return "";
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the target
     */
    public String getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * @return the relationship
     */
    public int getRelationship() {
        return relationship;
    }

    /**
     * @param relationship the relationship to set
     */
    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }
}
