package log4j;

import log4j.debug.Debugger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        logger.info("Appliction start.");

        System.out.println("running...");

        Debugger debugger = new Debugger();

        debugger.debug("Debugging appliation.");

        try {
            Integer.parseInt("x");
        } catch (Exception e) {
            logger.error("Application error.");
        }

        logger.info("Application end.");
    }
}
