package models;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    /* Класс Ticket пакета models реализуем по аналогии c домашним заданием по тестированию API.
       Класс должен содержать набор полей, необходимый для заполнения формы создания тикета.
       Тип данных для каждого поля должен соответствовать документации swagger (см. раздел Models в документации). */

    // todo: остальные поля класса
    private String title;
    private String due_date;
    private File file;
    private Integer id;
    private Integer priority;
    private String created;
    private String modified;
    private String submitter_email;
    private Integer status;
    private boolean on_hold;
    private String description;
    private String resolution;
    private String last_escalation;
    private String secret_key;
    private Integer queue;
    private Integer kbitem;
    private Integer merged_to;
    private String assigned_to;

    // todo: остальные геттеры и сеттеры

    public Ticket() {
    }

    public Integer getMerged_to() {
        return merged_to;
    }

    public void setMerged_to(Integer merged_to) {
        this.merged_to = merged_to;
    }

    public Integer getKbitem() {
        return kbitem;
    }

    public void setKbitem(Integer kbitem) {
        this.kbitem = kbitem;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secretKey) {
        this.secret_key = secretKey;
    }

    public String getLastEscalation() {
        return last_escalation;
    }

    public void setLastEscalation(String lastEscalation) {
        this.last_escalation = lastEscalation;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOn_hold() {
        return on_hold;
    }

    public void setOn_hold(boolean onHold) {
        this.on_hold = onHold;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubmitter_EMail() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitterEMail) {
        this.submitter_email = submitterEMail;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    // обычный сеттер
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    // перегруженный сеттер, который принимает дату и форматирует её в строку по шаблону
    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
    public String getDue_date() {
        return due_date;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
