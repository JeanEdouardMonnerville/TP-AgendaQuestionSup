package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    private HashSet<LocalDate> exceptions = new HashSet<>();
    private ChronoUnit frequency;

    public HashSet<LocalDate> getExceptions() {
        return exceptions;
    }
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        exceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return this.frequency;
    }
    
    @Override
    public boolean isInDay(LocalDate aDay){
        LocalDate cpt = this.getStart().toLocalDate();
        if (exceptions.contains(aDay)){
            return false;
        }
        while (cpt.isBefore(aDay)){
            switch (this.frequency){
                case DAYS:
                    cpt=cpt.plusDays(1);
                    break;
                case WEEKS:
                    cpt=cpt.plusWeeks(1);
                    break;
                case MONTHS:
                    cpt=cpt.plusMonths(1);
                    break;
            }
        }
        return cpt.isEqual(aDay);
    }

}
