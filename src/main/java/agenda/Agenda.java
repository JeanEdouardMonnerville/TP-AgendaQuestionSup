package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        events.stream().filter(e -> (e.isInDay(day))).forEachOrdered(e -> {
            ListeEvent.add(e);
        });
        return ListeEvent;
    }
     /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public HashSet<Event> findByTitle(String title) {
       HashSet<Event> ListeEvent=new HashSet();
       events.stream().filter(e -> (e.getTitle().equals(title))).forEachOrdered(e -> {
           ListeEvent.add(e);
        });
        return ListeEvent;       
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        
        for(Event ev:events){
            LocalDateTime evEnd=ev.getStart().plus(ev.getDuration());//Date de fin des events programmé
            LocalDateTime eEnd=e.getStart().plus(e.getDuration());//Date de fin des events programmé
            LocalDateTime evStart=ev.getStart();//Date de début des events programmé
            LocalDateTime eStart=e.getStart();//Date de début des events programmé
            
         if( ev.getStart().equals(e.getStart())||
                 (evStart.isBefore(eStart) && evEnd.isAfter(eEnd)) ) {
                 
            return false;}
         }
        return true;
     
    }
}
