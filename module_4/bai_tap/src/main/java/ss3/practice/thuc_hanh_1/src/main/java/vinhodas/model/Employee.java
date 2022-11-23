package vinhodas.model;

public class Employee {
    private int id;
    private String name;
    private String contactName;

    public Employee() {
    }

    public Employee(int id, String name, String contactName) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Object getContactNumber() {
        return null;
    }
}
