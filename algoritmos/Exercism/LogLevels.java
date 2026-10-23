
class LogLevels {

    static String message(String logLine) {
        return logLine.substring(logLine.indexOf(":") + 1).trim();
    }

    static String logLevel(String logLine) {
        String level = logLine.substring(
            logLine.indexOf("[") + 1,
            logLine.indexOf("]")
        );

        return level.toLowerCase();
    }

    static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
