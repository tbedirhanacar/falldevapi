package Utilities;

import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {

    public static void saveRegistrantData(String fileName, Registrant registrant){

        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(registrant.getFirstName()+", "+registrant.getLastName()+", "+ registrant.getPassword()+ ", "+
                    registrant.getSsn()+", "+registrant.getLogin()+", "+registrant.getEmail()+",\n");

            writer.close();


        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
