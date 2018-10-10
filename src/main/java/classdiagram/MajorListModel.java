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

/**
 *
 * @author fitexmage
 */
public class MajorListModel {

    private ArrayList<MajorModel> majorList;
    private String majorFileName = "src/main/resources/static/major.json";

    public MajorListModel() {
        majorList = new ArrayList<MajorModel>();
        readFile();
    }

    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            majorList = mapper.readValue(new File(majorFileName), new TypeReference<ArrayList<MajorModel>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(majorFileName), majorList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void removeMajor(int id) {
        for (MajorModel theMajorModel : majorList) {
            if (theMajorModel.getId() == id) {
                majorList.remove(theMajorModel);
                break;
            }
        }
    }

    public void addMajor(String major) {
        if (majorIndex(major) == -1) {
            ArrayList<CourseModel> courseList = new ArrayList<CourseModel>();
            ArrayList<LinkModel> linkList = new ArrayList<LinkModel>();
            MajorModel newMajor = new MajorModel(newMajorID(), major, courseList, linkList);
            majorList.add(newMajor);
        }
    }

    public void addTestData() {
        ArrayList<CourseModel> courseList = new ArrayList<CourseModel>();
        CourseModel newCourseModel1 = new CourseModel(1, "IST 110", 1, 1, "");
        CourseModel newCourseModel2 = new CourseModel(2, "IST 210", 2, 1, "");
        CourseModel newCourseModel3 = new CourseModel(3, "IST 220", 2, 1, "");
        courseList.add(newCourseModel1);
        courseList.add(newCourseModel2);
        courseList.add(newCourseModel3);

        ArrayList<LinkModel> linkList = new ArrayList<LinkModel>();
        LinkModel newLinkModel1 = new LinkModel("IST 110", "IST 210", 1);
        LinkModel newLinkModel2 = new LinkModel("IST 110", "IST 220", 1);
        linkList.add(newLinkModel1);
        linkList.add(newLinkModel2);

        MajorModel newMajorModel = new MajorModel(1, "Design and Development", courseList, linkList);
        majorList.add(newMajorModel);
    }

    public MajorModel major(int id) {
        for (MajorModel theMajorModel : majorList) {
            if (theMajorModel.getId() == id) {
                return theMajorModel;
            }
        }
        return null;
    }

    public int majorIndex(String major) {
        for (int i = 0; i < majorList.size(); i++) {
            if (majorList.get(i).getMajor().equals(major)) {
                return i;
            }
        }
        return -1;
    }

    public int newMajorID() {
        int highest = 0;
        for(MajorModel theMajorModel: majorList){
            if(theMajorModel.getId() > highest){
                highest = theMajorModel.getId();
            }
        }
        return highest + 1;
    }

    /**
     * @return the majorList
     */
    public ArrayList<MajorModel> getMajorList() {
        return majorList;
    }

    /**
     * @param majorList the majorList to set
     */
    public void setMajorList(ArrayList<MajorModel> majorList) {
        this.majorList = majorList;
    }

    /**
     * @return the majorFileName
     */
    public String getMajorFileName() {
        return majorFileName;
    }

    /**
     * @param majorFileName the majorFileName to set
     */
    public void setMajorFileName(String majorFileName) {
        this.majorFileName = majorFileName;
    }
}
