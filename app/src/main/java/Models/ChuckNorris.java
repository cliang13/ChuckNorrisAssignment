package Models;

public class ChuckNorris
{
 public String value;
 public String id;

    public ChuckNorris(
       String value,
            String id) {
    this.value = value;
        this.id = id;
    }

 public String getValue() {
       return value;
    }

   public void setValue(String value) {
     this.value = value;
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}