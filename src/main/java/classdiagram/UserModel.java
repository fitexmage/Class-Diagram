/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdiagram;

import java.util.HashMap;

/**
 *
 * @author fitexmage
 */
public class UserModel {

    private int id;
    private HashMap<Integer, Integer> stateList;

    public UserModel(int id, HashMap<Integer, Integer> stateList) {
        this.id = id;
        this.stateList = stateList;
    }

    public UserModel() {

    }

    public String stateToString(int state) {
        switch (state) {
            case (0):
                return "Not taken";
            case (1):
                return "Taken";
            case (2):
                return "Taking";
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
     * @return the stateList
     */
    public HashMap<Integer, Integer> getStateList() {
        return stateList;
    }

    /**
     * @param stateList the stateList to set
     */
    public void setStateList(HashMap<Integer, Integer> stateList) {
        this.stateList = stateList;
    }
}
