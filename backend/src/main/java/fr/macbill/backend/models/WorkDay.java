package fr.macbill.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;

@Document(collection = "workDay")
@Data
public class WorkDay {

    @Id
    private String id;

    private boolean allDay;

    private HashMap<String, String> color;

    private boolean draggable;

    private Date end;

    private Date start;

    private String title;

    private String customerId;

    private String userId;

    private  boolean isTva;

    private double price;
}
