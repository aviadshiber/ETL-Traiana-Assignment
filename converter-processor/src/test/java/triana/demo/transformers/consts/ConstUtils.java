package triana.demo.transformers.consts;

public class ConstUtils {
    public static final String CSV_BODY_STRING = "rep_file_num,CIK,entity_name,street1,street2,city,state_code,zip,filing_date,doc_type_code \n" +
            "814-00034,0000731812,SIERRA RESOURCES CORP,629 J STREET,SUITE 202,SACRAMENTO,CA,95814,12/30/96,15 \n" +
            "814-00053,0000821472,WESTFORD TECHNOLOGY VENTURES LP,17 ACADEMY ST 5TH FLOOR,[NULL],NEWARK,NJ,07102-2905,01/28/04,NO ACT ... \n" +
            "814-00098,0000878932,\"EQUUS TOTAL RETURN, INC.\",EIGHT GREENWAY PLAZA,SUITE 930,HOUSTON,TX,77046,08/25/16,40-APP/A";

    public static final String XML_BODY_STRING = "<Active>true</Active><Details>null</Details><ID>1</ID><Fees>1000.21</Fees><Name>Robert</Name>";

    public static final String XML_TO_JSON_EXPECTED_RESULT = "{\n" +
            "    \"Active\": true,\n" +
            "    \"Details\": null,\n" +
            "    \"ID\": 1,\n" +
            "    \"Fees\": 1000.21,\n" +
            "    \"Name\": \"Robert\"\n" +
            "}";

    public static final String CSV_TO_JSON_EXPECTED_RESULT = "[{\"rep_file_num\":\"814-00034\",\"CIK\":\"0000731812\",\"entity_name\":\"SIERRA RESOURCES CORP\",\"street1\":\"629 J STREET\",\"street2\":\"SUITE 202\",\"city\":\"SACRAMENTO\",\"state_code\":\"CA\",\"zip\":\"95814\",\"filing_date\":\"12/30/96\",\"doc_type_code\":\"15 \"},{\"rep_file_num\":\"814-00053\",\"CIK\":\"0000821472\",\"entity_name\":\"WESTFORD TECHNOLOGY VENTURES LP\",\"street1\":\"17 ACADEMY ST 5TH FLOOR\",\"street2\":\"[NULL]\",\"city\":\"NEWARK\",\"state_code\":\"NJ\",\"zip\":\"07102-2905\",\"filing_date\":\"01/28/04\",\"doc_type_code\":\"NO ACT ... \"},{\"rep_file_num\":\"814-00098\",\"CIK\":\"0000878932\",\"entity_name\":\"EQUUS TOTAL RETURN, INC.\",\"street1\":\"EIGHT GREENWAY PLAZA\",\"street2\":\"SUITE 930\",\"city\":\"HOUSTON\",\"state_code\":\"TX\",\"zip\":\"77046\",\"filing_date\":\"08/25/16\",\"doc_type_code\":\"40-APP/A\"}]";

}
