/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdiagram;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author fitexmage
 */
public class UserListModel {
    
    private ArrayList<UserModel> userList;
    private String userFileName = "src/main/resources/static/user.json";

    public UserListModel() {
        userList = new ArrayList<UserModel>();
        readFile();
    }

    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            userList = mapper.readValue(new File(userFileName), new TypeReference<ArrayList<UserModel>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(userFileName), userList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeUser(int id) {
        for (UserModel thUserModel : userList) {
            if (thUserModel.getId() == id) {
                userList.remove(thUserModel);
                break;
            }
        }
    }
    
    public void addTestData() {
        HashMap<Integer, Integer> stateList = new HashMap<Integer, Integer>();
        stateList.put(1, 0);
        stateList.put(2, 0);
        userList.add(new UserModel(1, stateList));
    }

    public UserModel user(int id) {
        for (UserModel theUserModel : userList) {
            if (theUserModel.getId() == id) {
                return theUserModel;
            }
        }
        return null;
    }

    public int newMajorID() {
        int highest = 0;
        for(UserModel theUserModel: userList){
            if(theUserModel.getId() > highest){
                highest = theUserModel.getId();
            }
        }
        return highest + 1;
    }
}
