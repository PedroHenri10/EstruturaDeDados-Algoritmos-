import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {

    LocalDateTime schedule(String appointmentDate) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss");

        return LocalDateTime.parse(appointmentDate, formatter);
    }

    boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();

        return hour >= 12 && hour < 18;
    }

    String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "EEEE, MMMM d, yyyy, 'at' h:mm a.",
                Locale.ENGLISH
        );

        return "You have an appointment on " + formatter.format(appointmentDate);
    }

    LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }
}
