package com.redsea.mas.serviceImpl;


import com.redsea.mas.domain.*;
import com.redsea.mas.repository.EventRecordRepository;
import com.redsea.mas.service.*;
import com.redsea.mas.util.ManualDataValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private StudentService studentService;
    private EventService eventService;
    private LocationService locationService;
    private EventTypeService eventTypeService;
    private BlockService durationService;
    private EventRecordRepository eventRecordRepository;

    @Autowired
    public EventRecordServiceImpl(StudentService studentService,
                                            EventService eventService,
                                            LocationService locationService,
                                            EventTypeService eventTypeService,
                                            BlockService durationService,
                                            EventRecordRepository eventRecordRepository) {
        this.durationService=durationService;
        this.studentService = studentService;
        this.eventService = eventService;
        this.locationService = locationService;
        this.eventTypeService = eventTypeService;
        this.eventRecordRepository =eventRecordRepository;
    }

    @Override
    public List<EventRecord> saveManualRecords(MultipartFile file) {
        List<EventRecord> records= new ArrayList<>();
        try {
            String content[]= new String(file.getBytes()).split("\n");
            Block duration=null;
            Event event= null;
            boolean newBlock;
            EventType eventType= eventTypeService.findByShortName(ManualDataValue.MM.name());
            Location location= locationService.findByShortName(ManualDataValue.DB.name());
            for (String line: content) {
                String[] values=line.split(",");
                int[] date = Arrays.stream(values[0].split("/")).mapToInt(Integer::parseInt).toArray();
                LocalDate localDate=LocalDate.of(date[2],date[0],date[1]);
                Student student= studentService.findStudentByStudentId(values[1]);
                if(duration ==null || !isBetweenThisBlock(duration,localDate)){
                    duration= durationService.findByDate(localDate);
                    newBlock=true;
                }else newBlock =false;

                if(event==null || newBlock){
                    event=eventService.findByBlockAndTypeAndLocation(duration,eventType,location);
                }
                records.add(new EventRecord(event,student,localDate));
            }

            records= (List<EventRecord>)eventRecordRepository.saveAll(records);
        }catch (Exception e){
            e.printStackTrace();
        }

        return records;
    }

    @Override
    public List<EventRecord> findByStudent(Student student) {
        return eventRecordRepository.findAllByStudent(student);
    }

    @Override
    public List<EventRecord> saveAutomaticRecords(MultipartFile file) {
          List<EventRecord> records= new ArrayList<>();
        try {
            String content= new String(file.getBytes());
            String singleValues[]= content.split("\n");
            Block duration=null;
            EventType eventType=null;
            Location location=null;
            boolean newBlock,newLocation,newEventType;
            Event event=null;
            for (String entity:singleValues) {
                String[] values=entity.split(",");
                Student student= studentService.findStudentByBarcode(values[0]);
                int[] date = Arrays.stream(values[1].split("/")).mapToInt(Integer::parseInt).toArray();
                LocalDate localDate=LocalDate.of(2000+date[2],date[0],date[1]);
                if(duration ==null || !isBetweenThisBlock(duration,localDate)){
                    duration= durationService.findByDate(localDate);
                    newBlock=true;
                }else newBlock =false;
                if(eventType== null || !eventType.getShortName().equals((values[2].equals("AM") || values[2].equals("EAM")) ? "MM": values[2])) {
                    String shortName = "";
                    if (values[2].equals("AM") || values[2].equals("EAM")) shortName = "MM";
                    else shortName = values[2];
                    eventType = eventTypeService.findByShortName(shortName);
                    newEventType=true;
                }else newEventType =false;
                String locationValue=values[3].substring(0,2);
                if(location == null || !location.getShortName().equals(locationValue)){
                    location = locationService.findByShortName(locationValue);
                    newLocation=true;
                }else newLocation =false;

                if(event==null || newBlock || newEventType || newLocation){
                    event=eventService.findByBlockAndTypeAndLocation(duration,eventType,location);
                }
                records.add(new EventRecord(event,student,localDate));


            }
            records= (List<EventRecord>)eventRecordRepository.saveAll(records);
        }catch (Exception e){
            e.printStackTrace();
        }
        return records;
    }

    private boolean isBetweenThisBlock(Block duration,LocalDate localDate){
        return ((localDate.isAfter(duration.getStartDate()) && localDate.isBefore(duration.getEndDate()))||
                localDate.isEqual(duration.getStartDate()) || localDate.isEqual(duration.getEndDate()));
    }
}
