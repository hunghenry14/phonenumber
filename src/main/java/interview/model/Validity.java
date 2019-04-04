package interview.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Validity {
    private LocalDate activationDate;

    private LocalDate deactivationDate;

    private static final Map<String, LocalDate> DATE_MAP = new HashMap<String, LocalDate>();

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getDeactivationDate() {
        return deactivationDate;
    }

    public Validity(String activationDate, String deactivationDate) {
        if (activationDate == null || activationDate.isEmpty()) {
            throw new IllegalArgumentException("Activation date must not be null!");
        }
        this.activationDate = convertToDate(activationDate);
        if (deactivationDate != null && !deactivationDate.isEmpty()) {
            this.deactivationDate = convertToDate(deactivationDate);
        }
        
        validate();
    }
    
    private void validate() {
        if(deactivationDate != null && activationDate.isAfter(deactivationDate)) {
            throw new IllegalArgumentException("Activation date must be before deactivation date!");
        }
    }
    
    public Validity(LocalDate activationDate, LocalDate deactivationDate) {
        this.activationDate = activationDate;
        this.deactivationDate = deactivationDate;
        validate();
    }

    
    private LocalDate convertToDate(String dateAsString) {
        LocalDate date = DATE_MAP.get(dateAsString);
        if (date == null) {
            date = LocalDate.parse(dateAsString, DATE_FORMATTER);
            DATE_MAP.put(dateAsString, date);
        }
        return date;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }


}
