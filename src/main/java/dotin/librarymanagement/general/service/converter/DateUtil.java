package dotin.librarymanagement.general.service.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public Date converter(String birthDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date;
        try {
            return date = dateFormat.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
