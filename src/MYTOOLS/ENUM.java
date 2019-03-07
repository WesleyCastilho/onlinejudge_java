package MYTOOLS;


public class ENUM {

    enum DB_CONNECTION {LOF4POS, CTS, CTSIL, LPOSEnq, SLA, AS400SpoolFile, AS400Update}

    public static void main(String[] args) {
        DB_CONNECTION connection = DB_CONNECTION.valueOf("LOF4POS");
    }
}
