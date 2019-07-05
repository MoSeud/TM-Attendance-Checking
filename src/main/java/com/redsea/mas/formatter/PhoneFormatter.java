package com.redsea.mas.formatter;

import com.redsea.mas.domain.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneFormatter implements Formatter<Phone> {
    @Override
    public Phone parse(String s, Locale locale) throws ParseException {
        System.out.println("from phone formatter");
        System.out.println(s);
        String[] value = s.split("-");
        if(value.length>4 || value.length<3){
            return new Phone(null,null,null);
        }
        String area =value[0];
        String prefix = value[1];
        String number = value[2];
        Phone phone = new Phone(Integer.valueOf(area), Integer.valueOf(prefix), Integer.valueOf(number));
        System.out.println(phone.toString());
        return phone;
    }

    @Override
    public String print(Phone phone, Locale locale) {

        System.out.println("Printing" + phone);
        return phone.getArea()+ "-" + phone.getPrefix() +
                "-" + phone.getNumbers();
    }
}
