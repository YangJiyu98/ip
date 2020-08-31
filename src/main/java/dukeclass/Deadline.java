package dukeclass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A type of task.
 * The task has a String message and a Boolean status.
 * in addition to that, it has a preposition and a timeline to be completed by
 */
public class Deadline extends Task{

    private static final String ICON = "D";
    private String preposition;
    private LocalDateTime dateTime;


    public Deadline(String taskString, String preposition, String dateTimeString) {
        super(taskString);
        this.preposition = preposition;
        this.dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public Deadline(String taskString, String preposition, String dateTimeString, boolean status) {
        super(taskString);
        this.preposition = preposition;
        this.dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.status = status;
    }

    @Override
    public String toString() {
        String statusIcon = (status)?"✓":"✗";
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
