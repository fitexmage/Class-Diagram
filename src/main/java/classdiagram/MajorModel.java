/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdiagram;

import java.util.ArrayList;

/**
 *
 * @author fitexmage
 */
public class MajorModel {

    private int id;
    private String major;
    private ArrayList<CourseModel> courseList;
    private ArrayList<LinkModel> linkList;

    public MajorModel(int id, String major, ArrayList<CourseModel> courseList, ArrayList<LinkModel> linkList) {
        this.id = id;
        this.major = major;
        this.courseList = courseList;
        this.linkList = linkList;
    }

    public MajorModel() {

    }

    public void removeCourse(String course) {
        courseList.remove(courseIndex(course));
        removeLink(course);
    }

    public void addCourse(int id, String course, int level, int required, String url) {
        if (courseIndex(course) == -1) {
            CourseModel newCourse = new CourseModel(id, course, level, required, url);
            courseList.add(newCourse);
        }
    }

    public int courseIndex(String course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getName().equals(course)) {
                return i;
            }
        }
        return -1;
    }

    public void removeLink(String source, String target) {
        linkList.remove(linkIndex(source, target));
    }

    public void removeLink(String course) {
        ArrayList<Integer> linkIndexList = linkIndex(course);
        if (!linkIndexList.isEmpty()) {
            for (int i : linkIndexList) {
                linkList.remove(i);
            }
        }
    }

    public void addLink(String source, String target, int relationship) {
        if (linkIndex(source, target) == -1 && !source.equals(target)) {
            LinkModel newLink = new LinkModel(source, target, relationship);
            linkList.add(newLink);
        }
    }

    public int linkIndex(String source, String target) {
        for (int i = 0; i < linkList.size(); i++) {
            if (linkList.get(i).getSource().equals(source) && linkList.get(i).getTarget().equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Integer> linkIndex(String course) {
        ArrayList<Integer> linkIndexList = new ArrayList<Integer>();

        for (int i = 0; i < linkList.size(); i++) {
            if (linkList.get(i).getSource().equals(course) || linkList.get(i).getTarget().equals(course)) {
                linkIndexList.add(i);
            }
        }
        return linkIndexList;
    }

    public ArrayList<LinkModel> prerequisite(String course) {
        ArrayList<LinkModel> prerequisiteList = new ArrayList<LinkModel>();
        for (LinkModel theLink : linkList) {
            if (theLink.getTarget().equals(course)) {
                prerequisiteList.add(theLink);
            }
        }
        return prerequisiteList;
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
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the courseList
     */
    public ArrayList<CourseModel> getCourseList() {
        return courseList;
    }

    /**
     * @param courseList the courseList to set
     */
    public void setCourseList(ArrayList<CourseModel> courseList) {
        this.courseList = courseList;
    }

    /**
     * @return the linkList
     */
    public ArrayList<LinkModel> getLinkList() {
        return linkList;
    }

    /**
     * @param linkList the linkList to set
     */
    public void setLinkList(ArrayList<LinkModel> linkList) {
        this.linkList = linkList;
    }
}
