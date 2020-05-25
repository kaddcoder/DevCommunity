package cat.urv.deim.asm.p3.shared;

import java.util.Date;

public class CalendarEntry {
    private String title;
    private String subtitle;
    private String img;
    private String date;


    public CalendarEntry(String title, String subtitle, String img, String date) {
        this.title = title;
        this.subtitle = subtitle;
        this.img = img;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
