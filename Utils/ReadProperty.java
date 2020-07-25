package Utils;

import Base.BaseTest;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadProperty extends BaseTest {

    public static String GetProperty(String propertyName) {
        String returnProperty = "";
        try {
            returnProperty = prop.getProperty(propertyName);

            if (returnProperty.isEmpty()) {

                throw new Exception("Property with name :" + propertyName + " is not found in the configuration, Please check the config File ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
            return returnProperty;
    }


}
