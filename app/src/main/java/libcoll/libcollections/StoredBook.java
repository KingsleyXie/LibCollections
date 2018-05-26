package libcoll.libcollections;

public class StoredBook {
    public int id;
    public String isbn;
    public String callno;
    public String location;
    public String remark;

    public StoredBook(
        int id,
        String isbn,
        String callno,
        String location,
        String remark) {
        this.id = id;
        this.isbn = isbn;
        this.callno = callno;
        this.location = location;
        this.remark = remark;
    }
}
