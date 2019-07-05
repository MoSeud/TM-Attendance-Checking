package com.redsea.mas.controller;

import com.redsea.mas.domain.Event;
import com.redsea.mas.domain.EventRecord;
import com.redsea.mas.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {


    private EventService eventService;
    private BlockService blockService;
    private EventTypeService eventTypeService;
    private LocationService locationService;
    private EventRecordService eventRecordService;


    @Autowired
    public EventController(EventService eventService,
                           BlockService blockService,
                           LocationService locationService,
                           EventTypeService eventTypeService,
                           EventRecordService eventRecordService) {
        this.eventService = eventService;
        this.blockService=blockService;
        this.eventTypeService=eventTypeService;
        this.locationService=locationService;
        this.eventRecordService =eventRecordService;
    }


    @GetMapping("list")
    public String list(Model model){

        model.addAttribute("events",eventService.findAll());

       // return "event/list";
        return "admin/eventList";
    }

    @GetMapping("add")
    public String addForm(@ModelAttribute Event event, Model model){
        getDependecyValue(model);
       // return "event/form";
        return "admin/addForm";
    }

    @PostMapping("add")
    public String save(@Valid @ModelAttribute("event") Event event, BindingResult result, RedirectAttributes redirect, Model model){
        if(result.hasErrors()){
            getDependecyValue(model);
            //return "event/form";
            return "admin/addForm";

        }
        String message="";
        try {
           message= event.getId() == null ? "event.successfully.saved" : "event.successfully.updated";
            eventService.save(event);
            redirect.addFlashAttribute("successMessage",message);
        }catch (Exception e){
            message= event.getId() == null ? "event.error.saved" : "event.error.updated";
            e.printStackTrace();
            redirect.addFlashAttribute("errorMessage",message);
        }

        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes redirect){
        Event event=eventService.findById(id);
        if(event == null) {
            redirect.addFlashAttribute("errorMessage","event.notFound");
            return "redirect:list";
        }
       getDependecyValue(model);
        model.addAttribute("event",event);
       // return "event/form";
        return "admin/addForm";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect){
        try {
            eventService.delete(id);
            redirect.addFlashAttribute("successMessage","event.success.delete");
        }catch (Exception e ){
            e.printStackTrace();
            redirect.addFlashAttribute("errorMessage","event.error.delete");
        }

        return "redirect:/event/list";
    }

    @PostMapping("attendanceRecordAutomatic")
    public String AutomaticUploadFile(@RequestParam("attendanceRecord") MultipartFile file, RedirectAttributes redirect){
       List<EventRecord> records=eventRecordService.saveAutomaticRecords(file);
        redirect.addFlashAttribute("records",records);
        redirect.addFlashAttribute("successMessage","automatic.file.upload.success");
        return "redirect:/event/uploadFile";
    }
    @PostMapping("attendanceRecordManual")
    public String ManualUploadFile(@RequestParam("attendanceRecord") MultipartFile file, RedirectAttributes redirect){

        List<EventRecord> records=eventRecordService.saveManualRecords(file);
        redirect.addFlashAttribute("records",records);
        redirect.addFlashAttribute("successMessage","manual.file.upload.success");
        return "redirect:/event/uploadFile";
    }
    @GetMapping("uploadFile")
    public String fileUpload(Model model){
        //return "event/attendanceRecord/form";
        return "admin/uploadForm";
    }



    private Model getDependecyValue(Model model){
        model.addAttribute("durations",blockService.findByYear( LocalDate.now().getYear()));
        model.addAttribute("eventTypes",eventTypeService.findAll());
        model.addAttribute("locations",locationService.findAll());

        return model;
    }
}
