package classdiagram;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    MajorListModel theMajorListModel;
    UserListModel theUserListModel;

    public MainController() {
        theMajorListModel = new MajorListModel();
        theUserListModel = new UserListModel();
    }
    
    @RequestMapping("/major-selection")
    public String majorSelection(Model model){
        model.addAttribute("majorList", theMajorListModel.getMajorList());
        return "major-selection";
    }

    @RequestMapping("/diagram")
    public String diagram(@RequestParam(value = "major", defaultValue = "") int major,
            Model model) {
        model.addAttribute("major", major);
        return "diagram";
    }

    @RequestMapping("/major-setting")
    public String majorSetting(Model model) {
        model.addAttribute("majorList", theMajorListModel.getMajorList());
        return "major-setting";
    }

    @RequestMapping("/delete-major")
    public String deleteMajor(@RequestParam(value = "major", defaultValue = "") int major,
            Model model) {

        theMajorListModel.removeMajor(major);

        theMajorListModel.writeFile();

        model.addAttribute("majorList", theMajorListModel.getMajorList());
        return "major-setting";
    }

    @RequestMapping("/add-major")
    public String addMajor(@RequestParam(value = "major", defaultValue = "") String major,
            Model model) {

        theMajorListModel.addMajor(major);

        theMajorListModel.writeFile();

        model.addAttribute("majorList", theMajorListModel.getMajorList());
        return "major-setting";
    }

    @RequestMapping("/course-setting")
    public String courseSetting(@RequestParam(value = "major", defaultValue = "") int major,
            Model model) {
        MajorModel theMajor = theMajorListModel.major(major);
        model.addAttribute("major", theMajor);
        return "course-setting";
    }

    @RequestMapping("/delete-course")
    public String deleteCourse(@RequestParam(value = "major", defaultValue = "") int major,
            @RequestParam(value = "course", defaultValue = "") String course,
            Model model) {

        MajorModel theMajor = theMajorListModel.major(major);
        theMajor.removeCourse(course);

        theMajorListModel.writeFile();

        model.addAttribute("major", theMajor);
        return "course-setting";
    }

    @RequestMapping("/add-course")
    public String addCourse(@RequestParam(value = "id", defaultValue = "") String id,
            @RequestParam(value = "course", defaultValue = "") String course,
            @RequestParam(value = "level", defaultValue = "") String level,
            @RequestParam(value = "required", defaultValue = "") String required,
            @RequestParam(value = "url", defaultValue = "") String url,
            @RequestParam(value = "major", defaultValue = "") int major,
            Model model) {

        MajorModel theMajor = theMajorListModel.major(major);
        theMajor.addCourse(Integer.parseInt(id), course, Integer.parseInt(level), Integer.parseInt(required), url);

        theMajorListModel.writeFile();

        model.addAttribute("major", theMajor);
        return "course-setting";
    }

    @RequestMapping("/prerequisite-setting")
    public String prerequisiteSetting(@RequestParam(value = "major", defaultValue = "") int major,
            @RequestParam(value = "course", defaultValue = "") String course,
            Model model) {
        MajorModel theMajor = theMajorListModel.major(major);
        CourseModel theCourse = theMajor.getCourseList().get(theMajor.courseIndex(course));
        ArrayList<LinkModel> linkList = theMajor.prerequisite(course);

        model.addAttribute("major", theMajor);
        model.addAttribute("course", theCourse);
        model.addAttribute("linkList", linkList);
        return "prerequisite-setting";
    }

    @RequestMapping("/delete-prerequisite")
    public String deletePrerequisite(@RequestParam(value = "major", defaultValue = "") int major,
            @RequestParam(value = "course", defaultValue = "") String course,
            @RequestParam(value = "prerequisite", defaultValue = "") String prerequisite,
            Model model) {
        MajorModel theMajor = theMajorListModel.major(major);
        CourseModel theCourse = theMajor.getCourseList().get(theMajor.courseIndex(course));
        theMajor.removeLink(prerequisite, course);
        
        ArrayList<LinkModel> linkList = theMajor.prerequisite(course);

        theMajorListModel.writeFile();

        model.addAttribute("major", theMajor);
        model.addAttribute("course", theCourse);
        model.addAttribute("linkList", linkList);
        return "prerequisite-setting";
    }

    @RequestMapping("/add-prerequisite")
    public String addPrerequisite(@RequestParam(value = "major", defaultValue = "") int major,
            @RequestParam(value = "course", defaultValue = "") String course,
            @RequestParam(value = "prerequisite", defaultValue = "") String prerequisite,
            @RequestParam(value = "relationship", defaultValue = "") String relationship,
            Model model) {
        MajorModel theMajor = theMajorListModel.major(major);
        CourseModel theCourse = theMajor.getCourseList().get(theMajor.courseIndex(course));
        theMajor.addLink(prerequisite, course, Integer.parseInt(relationship));
        ArrayList<LinkModel> linkList = theMajor.prerequisite(course);

        theMajorListModel.writeFile();

        model.addAttribute("major", theMajor);
        model.addAttribute("course", theCourse);
        model.addAttribute("linkList", linkList);
        return "prerequisite-setting";
    }
}
