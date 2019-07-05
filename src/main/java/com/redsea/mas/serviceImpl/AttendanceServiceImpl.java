package com.redsea.mas.serviceImpl;



import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Event;
import com.redsea.mas.domain.EventRecord;
import com.redsea.mas.domain.Student;
import com.redsea.mas.models.BlockAttendance;
import com.redsea.mas.models.CumulativeAttendance;
import com.redsea.mas.service.*;
import com.redsea.mas.util.ManualDataValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AttendanceServiceImpl implements AttendanceService {


    @Autowired
    private EventService eventService;
    @Autowired
    private  EventRecordService eventRecordService;
    @Autowired
    private  EventTypeService eventTypeService;
    @Autowired
    private  CalculateExtraPointService calculateExtraPointService;




    @Override
    public BlockAttendance getBlockAttendance(Student student, Block block) {

        Event event=eventService.findByBlockAndType(block,eventTypeService.findByShortName(ManualDataValue.MM.name()));

        return getSingleStudentAttendance(event,student);
    }

    @Override
    public Map<String,Boolean> getBlockAttendanceDateList(Student student, Block block) {

        Event event=eventService.findByBlockAndType(block,eventTypeService.findByShortName(ManualDataValue.MM.name()));

        return getBlockDateList(event,student);
    }

    private Map<String, Boolean> getBlockDateList(Event event, Student student) {
        Map<String, Boolean> blockList=new HashMap<>();
        List<EventRecord> studentRecord=event.getEventRecords().stream()
                .filter(record -> record.getStudent().getId()
                .equals(student.getId())).collect(Collectors.toList());
        LocalDate startDate=event.getBlock().getStartDate();
        LocalDate endDate=event.getBlock().getEndDate();
       do{
           for(EventRecord ev:studentRecord){
               if(ev.getDate().isEqual(startDate))
                   blockList.put(startDate.toString(),true);
                   else
                   blockList.put(startDate.toString(),false);
           }
           startDate=LocalDate.parse(addOneDay(startDate.toString()));
           System.out.println(startDate.toString());
        } while(startDate.isBefore(endDate));

        return blockList;
    }

        static public String addOneDay(String date) {
            return LocalDate.parse(date).plusDays(1).toString();
        }

    @Override
    public List<BlockAttendance> getAllStudentAttendance(List<Student> students, Block block) {
       final List<BlockAttendance> blockAttendances;
        Event event=eventService.findByBlockAndType(block,eventTypeService.findByShortName(ManualDataValue.MM.name()));
        blockAttendances = students.stream().map(student -> getSingleStudentAttendance(event, student)).collect(Collectors.toList());
        return blockAttendances;
    }

    @Override
    public CumulativeAttendance getStudentCumulative(Student student) {
        CumulativeAttendance attendance= new CumulativeAttendance();
        List<EventRecord> records= eventRecordService.findByStudent(student);
        Stream<Event> eventStream=records.stream().map(EventRecord::getEvent).distinct();
        Stream<Block> durationStream= eventStream.map(Event::getBlock);
        Integer totalSession=durationStream.mapToInt(Block::getNumberOfDays).sum();
        List<Block> blocks=records.stream().map(EventRecord::getEvent).distinct().map(Event::getBlock).collect(Collectors.toList());
        Double percentage= totalSession==0 ? 0: calculateExtraPointService.getPercentageAttendance(totalSession,records.size());
        attendance.setTotalAttended(records.size());
        attendance.setStudent(student);
        attendance.setTotalSession(totalSession);
        attendance.setBlocks(blocks);
        attendance.setAttendedPercent(percentage);
        return attendance;
    }

    @Override
    public List<CumulativeAttendance> getByEntry(List<Student> students) {
        final List<CumulativeAttendance> cumulativeAttendances= new ArrayList<>();
        students.forEach(student -> cumulativeAttendances.add(getStudentCumulative(student)));
        return cumulativeAttendances ;
    }

    private BlockAttendance getSingleStudentAttendance(Event event, Student student){
        BlockAttendance blockAttendance= new BlockAttendance();
        Stream<EventRecord> studentRecord=event.getEventRecords().stream().filter(record -> record.getStudent().getId().equals(student.getId()));
        Integer sessionInBlock=event.getBlock().getNumberOfDays();
        Integer dayPresent=(int)studentRecord.count();
        Double percentageAttend= calculateExtraPointService.getPercentageAttendance(sessionInBlock,dayPresent);
        blockAttendance.setStudent(student);
        blockAttendance.setBlock(event.getBlock());
        blockAttendance.setSessionsInBlock(sessionInBlock);
        blockAttendance.setDaysPresent(dayPresent);
        blockAttendance.setPercentageAttended(percentageAttend);
        blockAttendance.setExtraCreditPoints(calculateExtraPointService.getExtraPoint(percentageAttend));
        return blockAttendance;
    }
}
