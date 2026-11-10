package Ej;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class XML2JSONArray {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public static String TEST_XML_STRING =
        "<?xml version=\"1.0\" ?><root><test attrib=\"jsontext\">abctest</test>"
        + "<test attrib=\"jsontext2\">deftest</test></root>";

    public static void main(String[] args) {
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);

            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);

            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {

            System.out.println(je.toString());
        }
    }
}
