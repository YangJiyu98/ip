package dukeclass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A type of task.
 * The task has a String message and a Boolean status.
 * in addition to that, it has a preposition and a timeline to be completed by
 */
public class Deadline extends Task {

    private static final String ICON = "D";
    private String preposition;
    private LocalDateTime dateTime;


    /**
     * Constructor for Deadline task, status is set to false by default
     *
     * @param taskString  the task given by the user
     * @param preposition  the preposition for the time frame
     * @param dateTimeString  the time frame in a specific format of yyyy-MM-dd HH:mm
     */
    public Deadline(String taskString, String preposition, String dateTimeString) {
        super(taskString);
        this.preposition = preposition;
        this.dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    /**
     * Constructor for Deadline task but with ability to set status
     *
     * @param taskString  the task given by the user
     * @param preposition  the preposition for the time frame
     * @param dateTimeString  the time frame in a specific format of yyyy-MM-dd HH:mm
     * @param status  status of the task
     */
    public Deadline(String taskString, String preposition, String dateTimeString, boolean status) {
        super(taskString);
        this.preposition = preposition;
        this.dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.status = status;
    }

    @Override
    public String toString() {
        String statusIcon = (status) ? "\u2713" : "\u2713";
        return "[" + ICON + "]" + "[" + statusIcon + "] "
                + this.taskString + " (" + this.preposition + ": "
                + dateTime.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }

    @Override
    public String toDataString() {
        return "deadline//" + taskString + "//" + preposition + "//"
                + dateTime.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + "//" + status;
    }
}
