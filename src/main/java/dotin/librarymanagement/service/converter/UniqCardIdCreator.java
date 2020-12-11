package dotin.librarymanagement.service.converter;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;


@Service
public class UniqCardIdCreator {
    public String randomNumberProducer(String identifyCode) {

        UUID uuid = UUID.randomUUID();
        String partOfUUID = idBuilder(String.valueOf(uuid));
        Long timeStamp = Long.valueOf(new SimpleDateFormat("mmss").format(Calendar.getInstance().getTime()));
        if (identifyCode.length() == 8) {
            Long result = Long.valueOf(partOfUUID.substring(0, 3) + identifyCode.substring(0, 2) + timeStamp + Long.valueOf(identifyCode.substring(3, 7) + Long.valueOf(partOfUUID.substring(3, 5) + identifyCode.substring(8))));
            return String.valueOf(result);
        } else if (identifyCode.length() == 9) {
            Long result = Long.valueOf(partOfUUID.substring(0, 3) + identifyCode.substring(0, 2) + timeStamp + Long.valueOf(identifyCode.substring(3, 7) + Long.valueOf(partOfUUID.substring(3, 5) + identifyCode.substring(8, 9))));
            return String.valueOf(result);
        } else if (identifyCode.length() == 10) {
            Long result = Long.valueOf(partOfUUID.substring(0, 3) + identifyCode.substring(0, 2) + timeStamp + Long.valueOf(identifyCode.substring(3, 7) + Long.valueOf(partOfUUID.substring(3, 5) + identifyCode.substring(8, 10))));
            return String.valueOf(result);
        } else if (identifyCode.length() == 12) {
            Long result = Long.valueOf(partOfUUID.substring(0, 2) + identifyCode.substring(0, 3) + timeStamp + Long.valueOf(identifyCode.substring(4, 9) + Long.valueOf(partOfUUID.substring(3, 5) + identifyCode.substring(10, 12))));
            return String.valueOf(result);
        } else return String.valueOf(0);
    }

    private String idBuilder(String uuid) {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < uuid.length(); i++) {
            char values = uuid.charAt(i);
            if (Character.isDigit(values)) {
                numbers.append(values);
            }
        }
        return numbers.toString();
    }
}
