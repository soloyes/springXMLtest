import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger logger;

    private void logEvent(Event event) {
        logger.logEvent(event);
    }

    public App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans.xml");
        App app = (App) applicationContext.getBean("app");

        Event event = applicationContext.getBean(Event.class);
        app.logEvent(event);
        app.logEvent(event);
    }
}
