import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;
import util.SmartConsole;

/**
 * Created by jakub on 12/25/15.
 */
public class FileListener {
    private String filepath;

    private int watchID;

    private ServerManager serverManager;

    public FileListener(String filepath,
                        ServerManager serverManager){
        SmartConsole.Print("Creating FileListener");
        this.filepath = filepath;

        this.serverManager = serverManager;
    }

    public void startListener() throws JNotifyException{
        int mask = JNotify.FILE_MODIFIED;

        // watch subtree?
        boolean watchSubtree = false;

        // add actual watch
        watchID = JNotify.addWatch(filepath,
                                    mask,
                                    watchSubtree,
                                    new Listener(this, serverManager));

        SmartConsole.Print("Start Listener watch id: " + watchID);
        boolean do_continue = true;
        while(do_continue) {
            try {
                Thread.sleep(1000000000);
            } catch (Exception e) {   }
        }
    }

    public void stopListener() throws JNotifyException {
        SmartConsole.Print("Stop Listener watch id: " + watchID);
        boolean res = JNotify.removeWatch(watchID);
    }

}
