package chain_responsibility;
abstract class LogProcessor{
    public static int INFO= 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    
    LogProcessor nextLogProcessor;
    
    LogProcessor(LogProcessor logprocessor){
        this.nextLogProcessor=logprocessor;
    }
    
    public void log(int loglevel,String message){
        if(nextLogProcessor!=null)
        {
            nextLogProcessor.log(loglevel, message);
        }
    }
}

class InfoLog extends LogProcessor{
    InfoLog(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void log(int loglevel,String message){
        if(loglevel==INFO){
//            System.out.println("INFO: "+message);
        }
    }
}

class Debuglog extends LogProcessor{
    Debuglog(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void log(int loglevel,String message){
        if(loglevel==DEBUG){
            System.out.println("DEBUG: "+message);
        }
    }
}

class Errorlog extends LogProcessor{
    Errorlog(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void log(int loglevel,String message){
        if(loglevel==ERROR){
            System.out.println("ERROR: "+message);
        }
    }
}
public class Chain_responsibility {
    public static void main(String[] args) {
        LogProcessor logobj=new InfoLog(new Debuglog(new Errorlog(null)));
        
        logobj.log(LogProcessor.ERROR,"ERROR OCCURED");
        logobj.log(LogProcessor.DEBUG,"NEED TO DEBUG");
        logobj.log(LogProcessor.INFO,"JUST FOR INFO");
    }
}
