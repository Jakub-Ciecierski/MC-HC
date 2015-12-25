import util.FileUtils;
import util.SmartConsole;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 12/25/15.
 */
public class ServerManager {
    private final String WORLD_DIR_PATH = "world";
    private final String LOGS_DIR_PATH = "logs";
    private final String LATEST_LOGS_PATH = "latest.log";
    private final String PATH_SEP = "/";


    private String serverDIRPath;
    private String currentLogPath;
    private String worldPath;

    private FileListener fileListener;

    public ServerManager(String serverDIRPath) {
        this.serverDIRPath = serverDIRPath;

        currentLogPath = serverDIRPath + PATH_SEP +
                LOGS_DIR_PATH + PATH_SEP +
                LATEST_LOGS_PATH;

        worldPath = serverDIRPath + PATH_SEP + WORLD_DIR_PATH;

        SmartConsole.Print("Logs: " +  currentLogPath);
    }

    public void startServerManager(){
        SmartConsole.Print("Starting Server Manager");

        FileListener fileListener = new FileListener(currentLogPath, this);
        try {
            fileListener.startListener();
            fileListener.stopListener();
        }catch(Exception e){e.printStackTrace();}
    }

    public void readLogs(){
        try {
            FileReader fileReader = new FileReader(currentLogPath);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            while(line != null){
                SmartConsole.Print(line);
                line = br.readLine();
                if(line == null) return;

                if(!InfoRegexer.isSay(line) && InfoRegexer.isDeath(line)) {
                    destroyServer();
                    return;
                }
            }
        }catch(Exception e){e.printStackTrace();}
    }


    public void destroyServer(){
        try{
            SmartConsole.Print("Destroying Server, Better luck next time...",
                                SmartConsole.DebugModes.SERVER_MANAGER);
        }catch(Exception e){}
        SmartConsole.Print("Deleting: " + worldPath);
        FileUtils.deleteDirectory(new File(worldPath));

        try {
            Runtime rt = Runtime.getRuntime();

            String cmdLinux = "killall java";
            String cmdWin = "taskkill /im java.exe";
            rt.exec(cmdLinux);
            rt.exec(cmdWin);
            //Process pr = rt.exec("exit");
        }catch(Exception e){}
    }

    // Checks the structure of the directory
    // to determine whether is it a proper server directory.
    public boolean isProperServerDIR(String serverDIRPath){
        return true;
    }
}
