import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class RunJetty {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8090);

        WebAppContext context = new WebAppContext();
        context.setDescriptor("web/WEB-INF/web.xml");
        context.setResourceBase("web");
        context.setContextPath("/easy");
        context.setParentLoaderPriority(true);

        server.setHandler(context);

        server.start();
        server.join();

    }

}
