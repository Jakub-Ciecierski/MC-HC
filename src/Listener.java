import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;
import net.contentobjects.jnotify.JNotifyListener;
import util.SmartConsole;

/**
 * Created by jakub on 12/25/15.
 */

class Listener implements JNotifyListener {
    private FileListener fileListener;
    private ServerManager serverManager;

    public Listener(){
    }

    public Listener(FileListener fileListener){
        this.fileListener = fileListener;
    }

    public Listener(FileListener fileListener,
                    ServerManager serverManager){
        this.fileListener = fileListener;
        this.serverManager = serverManager;
    }

    public Listener(ServerManager serverManager){
        this.serverManager = serverManager;
    }

    public void fileRenamed(int wd, String rootPath, String oldName,
                            String newName) {
    }

    public void fileModified(int wd, String rootPath, String name) {
        SmartConsole.Print("File modifed: " + rootPath + " : "
                + name + "wd: " + wd, SmartConsole.DebugModes.FILE_LISTENER);

        serverManager.readLogs();
    }

    public void fileDeleted(int wd, String rootPath, String name) {
    }

    public void fileCreated(int wd, String rootPath, String name) {
    }

}