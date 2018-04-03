package log4j.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Debugger {

    private static final Logger logger = LoggerFactory.getLogger(Debugger.class);

    public void debug(String message) {
        logger.debug(message);
    }
}
