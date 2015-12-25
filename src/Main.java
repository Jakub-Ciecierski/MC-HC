import net.contentobjects.jnotify.JNotify;
import util.FileUtils;
import util.SmartConsole;

import java.io.File;
import java.lang.reflect.Field;
import java.rmi.server.ExportException;

class Main {
    public static void main(String[] args){
        if(isLinux()){
            SmartConsole.Print("Welcome Linux user",
                    SmartConsole.DebugModes.ADVANCED);
        }
        if(isWindows()){
            SmartConsole.Print("Welcome fgt Windows user",
                    SmartConsole.DebugModes.ADVANCED);
        }
        setCrossPlatformJNotify();

        try{

            String serverDir = args[0];
            //FileUtils.deleteDirectory(new File(serverDir));

            ServerManager serverManager = new ServerManager(serverDir);
            serverManager.startServerManager();

        }catch(Exception e){e.printStackTrace();}

    }

    public static void setCrossPlatformJNotify(){
        String relativePathToJNotify = "./lib/jnotify-lib-0.94/";
        if(isLinux())
            relativePathToJNotify += "linux_64/";
        if(isWindows())
            relativePathToJNotify += "jnotify_64bit.dll";


        System.setProperty("java.library.path", relativePathToJNotify);

        try {
            Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);
        }catch(Exception e){}

    }



    private static String OS = null;
    public static String getOsName()
    {
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }
    public static boolean isWindows()
    {
        return getOsName().startsWith("Windows");
    }

    public static boolean isLinux(){
        return getOsName().startsWith("Linux");
    }


}