package util;

public class SmartConsole
{

   private static String PREFIX = " >> ";

   private static String SUFFIX = "\n";

   static DebugModes[] DEBUG_MDOE = {DebugModes.ADVANCED,
                                    DebugModes.FILE_LISTENER,
                                    DebugModes.SERVER_MANAGER};

   public enum DebugModes {
      STDOUT,
      BASIC,
      ADVANCED,
      FILE_LISTENER,
      SERVER_MANAGER;

      public String toString()
      {
         if(this == STDOUT)
         {
            return "STDOUT";
         }
         if(this == ADVANCED)
         {
            return "Advanced";
         }
         if(this == BASIC)
         {
            return "Basic";
         }
         if(this == FILE_LISTENER){
            return "File-Listener";
         }
         if(this == SERVER_MANAGER){
            return "Server-Manager";
         }

      	return "";
   	}
   }

   public static void Print(String msg, DebugModes debugMode)
   {
      boolean doPrint = false;

      for(DebugModes workingDebugMode : DEBUG_MDOE){
      	if( workingDebugMode == debugMode){
      		doPrint = true;
      		break;
      	}
      }

      if(debugMode == DebugModes.STDOUT){
      	doPrint = true;
      }

      if(doPrint){
      		System.out.println("["+debugMode.toString()+ "]"+ PREFIX + msg + SUFFIX);
      }

	}

   public static void Print(String msg)
   {
      Print(msg, DebugModes.STDOUT);
   }

}
