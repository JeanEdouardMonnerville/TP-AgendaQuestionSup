package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    private HashSet<Event> events = new HashSet<>();
    
    public Agenda(){}
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public HashSet<Event> eventsInDay(LocalDate day) {
        HashSet<Event> ListeEvent=new HashSet();
        for(Event e:events){
            if (e.isInDay(day))
                ListeEvent.add(e);}
        return ListeEvent;
    }
}
