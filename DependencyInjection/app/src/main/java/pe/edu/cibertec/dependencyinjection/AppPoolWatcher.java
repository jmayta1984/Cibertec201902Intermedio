package pe.edu.cibertec.dependencyinjection;

public class AppPoolWatcher {

    INotificationAction action = null;


    // Inyección de propiedad (atributo)
    public INotificationAction getAction() {
        return action;
    }

    public void setAction(INotificationAction action) {
        this.action = action;
    }

    /* Base
    public void notify(String message) {
        if (action == null) {
            //action = new EventLogWriter();
            //action = new SmsSender();

            action = new EmailSender();
            ///eventLogWriter = new EventLogWriter();
        }
        action.write(message);
    }
    */

    // Inyección de constructor
    /*
    public AppPoolWatcher(INotificationAction action) {
        this.action = action;
    }
    */


    public void notify(String message) {
        action.write(message);
    }


    // Inyección de método
    public void notify(INotificationAction action, String message) {
        this.action = action;
        this.action.write(message);
    }

}
