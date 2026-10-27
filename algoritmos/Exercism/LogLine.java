public enum LogLevel {
    UNKNOWN("XYZ", 0),
    TRACE("TRC", 1),
    DEBUG("DBG", 2),
    INFO("INF", 4),
    WARNING("WRN", 5),
    ERROR("ERR", 6),
    FATAL("FTL", 42);

    private final String code;
    private final int encodedLevel;

    LogLevel(String code, int encodedLevel) {
        this.code = code;
        this.encodedLevel = encodedLevel;
    }

    public int getEncodedLevel() {
        return encodedLevel;
    }

    public static LogLevel fromCode(String code) {
        for (LogLevel level : values()) {
            if (level != UNKNOWN && level.code.equals(code)) {
                return level;
            }
        }

        return UNKNOWN;
    }
}
public class LogLine {

    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String code = logLine.substring(1, logLine.indexOf(']'));

        return LogLevel.fromCode(code);
    }

    public String getOutputForShortLog() {
        String message = logLine.substring(logLine.indexOf(':') + 1).trim();

        return getLogLevel().getEncodedLevel() + ":" + message;
    }
}
