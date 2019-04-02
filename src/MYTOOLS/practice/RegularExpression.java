package MYTOOLS.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    static String text = "\n"
            + "Insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1012001, 1012, 'Close Auto', 1, null, 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "Insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1012001, 1012, 'Close Auto', 1, null, 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "DELETE FROM table WHERE search_condition ORDER BY criteria LIMIT row_count OFFSET offset;\n\n"
            + "UPDATE Customers SET ContactName = 'Alfred Schmidt', City= 'Frankfurt' WHERE CustomerID = 1;\n\n"
            + "SELECT * FROM WHERE row_number <= 11;\n\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1012003, 1012, 'Close Manual RPRM', 1, null, 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1012004, 1012, 'Close Manual PPAYK', 1, null, 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1012005, 1012, 'Close Manual GRPA', 1, null, 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1012006, 1012, 'Close Manual NONA', 1, null, 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('07-04-2017 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1013001, 1013, 'สร้างใบ PAYIN', 1, null, 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1013002, 1013, 'ส่งถึงเจ้าหน้าที่และรอการตรวจรับ', 1, null, 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1013003, 1013, 'ตรวจรับและบันทึกการนำฝากสมบูรณ์', 1, null, 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1014001, 1014, '1014001=ยังไม่นำฝาก', 1, null, 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1014002, 1014, '1014002=นำฝากบางส่วน', 1, null, 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n"
            + "insert into mst_optiondetail (MST_OPTIONDETAIL_ID, MST_OPTIONHEAD_ID, OPTIONDETAIL_DESC, STATUS_FLAG, MAP_CODE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, OPTIONDETAIL_SHORT)\n"
            + "values (1014003, 1014, '1014003=นำฝากเต็มจำนวน', 1, null, 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('06-11-2018 12:49:57', 'dd-mm-yyyy hh24:mi:ss'), null);\n\n\n";


    public static void main(String[] args) {

        String regex = "(?i)insert\\s+into\\s+\\w+\\s+(\\(.*\\))?\\s+values\\s\\(?.*\\);|update\\s+\\w+\\s+set\\s+.*;|delete\\s+from\\s+\\w+((.*))?;|select\\s+(.*)\\s+from\\s+.*;";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(0) + "\n");
//            System.out.println("Full match: " + matcher.group(0));
//            for (int i = 1; i <= matcher.groupCount(); i++) {
//                System.out.println("Group " + i + ": " + matcher.group(i));
//            }
        }

    }




}
