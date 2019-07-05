package com.redsea.mas.controller;

import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Faculty;
import com.redsea.mas.domain.Section;
import com.redsea.mas.domain.Student;
import com.redsea.mas.models.CumulativeAttendance;
import com.redsea.mas.service.*;
import com.redsea.mas.util.Entries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/attendance")
public class AttendanceController {


    private FacultyService facultyService;

    private SectionService sectionService;

    private BlockService blockService;

    private StudentService studentService;

    private AttendanceService attendanceService;

    @Autowired
    public AttendanceController(FacultyService facultyService, SectionService sectionService, BlockService blockService,StudentService studentService,AttendanceService attendanceService) {
        this.facultyService = facultyService;
        this.sectionService = sectionService;
        this.blockService = blockService;
        this.studentService = studentService;
        this.attendanceService = attendanceService;
    }

    @GetMapping()
    public String studentAttendance(Model model, HttpSession session){
        Long id=(Long) session.getAttribute("id");
        Faculty faculty= facultyService.findById(id);
        model.addAttribute("durations",sectionService.blockTeachByProfessors(faculty));

        return "faculty/studentAttenFaculty";
    }

    @PostMapping("getStudents")
    @ResponseBody
    public List<Student> getStudents(@RequestParam("block") String blockId, Model model, HttpSession session){
        Long blockIdL= Long.parseLong(blockId);
        Long id=(Long) session.getAttribute("id");
        Faculty faculty= facultyService.findById(id);
        Block duration=blockService.findById(blockIdL);
        Section section=sectionService.findByFacultyAndBlock(faculty,duration);
        return section.getStudents();

    }
    @PostMapping("view")
    public String viewStudentAttendance(@RequestParam("student") Long student, @RequestParam("duration") Long duration, RedirectAttributes redirect, Model model, HttpSession session){
        Block duration1=blockService.findById(duration);
        if(student == 0){
            Long id=(Long) session.getAttribute("id");
            Faculty faculty= facultyService.findById(id);
            Section section=sectionService.findByFacultyAndBlock(faculty,duration1);
            redirect.addFlashAttribute("attendances",attendanceService.getAllStudentAttendance(section.getStudents(),duration1));
        }else {
            Student student1 = studentService.findById(student);
            redirect.addFlashAttribute("attendance",  attendanceService.getBlockAttendance(student1, duration1));
        }
        return "redirect:/attendance/viewStudentAttendance";
    }

    @GetMapping("viewStudentAttendance")
    public String viewStudentAttendance(Model model, HttpSession session){
        Long id=(Long) session.getAttribute("id");
        Faculty faculty= facultyService.findById(id);
        model.addAttribute("durations",sectionService.blockTeachByProfessors(faculty));

        return "faculty/studentAttenFaculty";
    }

    @GetMapping("cumulativeAttendance")
    public String viewCumulative(Model model, HttpSession session){
        Long id=(Long) session.getAttribute("id");
        Student student = studentService.findById(id);
        CumulativeAttendance cumulativeAttendance= attendanceService.getStudentCumulative(student);

        model.addAttribute("cumulative",cumulativeAttendance);
        model.addAttribute("durations", cumulativeAttendance.getBlocks());

        return "student/studentAttendance";


    }

    @PostMapping("viewAttendance")
    public String viewStudent(@RequestParam("duration") Long duration, RedirectAttributes redirect, Model model, HttpSession session){
        Long id=(Long) session.getAttribute("id");
        Student student = studentService.findById(id);
        Block block1=blockService.findById(duration);
            redirect.addFlashAttribute("attendance",  attendanceService.getBlockAttendance(student, block1));
        redirect.addFlashAttribute("attendance",  attendanceService.getBlockAttendance(student, block1));
        redirect.addFlashAttribute("datelist",  attendanceService.getBlockAttendanceDateList(student, block1));

        return "redirect:/attendance/cumulativeAttendance";
    }
    @GetMapping("getByEntry")
    public String getAllByEntry(Model model){
        model.addAttribute("entries", Entries.getEntries());
        return "admin/studentAttendanceForm";
    }

    @PostMapping("getByEntry")
    public String getByEntry(@RequestParam("entry") String entry, RedirectAttributes redirect){
        LocalDate localDate=Entries.getEntries().get(entry);
        List<Student> students=studentService.findStudentsByEntry(localDate);
        redirect.addFlashAttribute("attendances",attendanceService.getByEntry(students));
        return "redirect:/attendance/cumulativeByEntry";
    }

    @GetMapping("cumulativeByEntry")
    public String cumulativeByEntry(Model model){
        model.addAttribute("entries",Entries.getEntries());
        return "admin/studentAttendanceForm";
    }

}
