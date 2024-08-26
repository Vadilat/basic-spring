package com.handson.basic.util;

import com.sendgrid.*;
import okhttp3.OkHttpClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {
    protected final Log logger = LogFactory.getLog(getClass());
    OkHttpClient client = new OkHttpClient.Builder().build();

    public boolean send(String text,String dest, String subject) {

        //src will be a predefined address
        //target will be the email of the student from the DB
        //String dest = "vadilat@gmail.com";
        String src = "vadim.cybonet@gmail.com";
        //String subject = "Urgent MSG";

//  public boolean send(String text, String phoneNumber) {
        if (dest == null) return false;

        //String key = "SENDGRID_API_KEY";
        String apiKey = "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";

        Email from = new Email(src);
        Email to = new Email(dest);
        Content content = new Content("text/plain", text);
        Mail mail = new Mail(from, subject, to, content);

        //SendGrid sg = new SendGrid(System.getenv(key));
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

            boolean success = response.getStatusCode() < 300 && response.getStatusCode() >= 200;

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

            return success;

        } catch (IOException ex) {
             ex.printStackTrace();
             return false;
        }
    }
}