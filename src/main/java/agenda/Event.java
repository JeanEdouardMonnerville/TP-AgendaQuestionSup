package agenda;

import java.time.*;
import java.util.ArrayList;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        ArrayList<LocalDate> dureeEvent=new ArrayList();

        int year=myStart.getYear();
        int month=myStart.getMonthValue();
        int dayOfMonth=myStart.getDayOfMonth();
        

        LocalDate date=LocalDate.of(year,month,dayOfMonth);
        long duree=myDuration.toDays();
        for(long i=0;i<duree;i++){
            date=date.plusDays(i);
            dureeEvent.add(date);
            }
        if(dureeEvent.contains(aDay)){
            return true;}
        return false;
            
        
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

   
    
}
