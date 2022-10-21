import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import java.io.File;
/*
    TODO
    преобразование объекта в json строку, 
    запись json в файл, 
    чтение json из файла
*/
@Slf4j
public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        SomeClass clazz = new SomeClass("text", 21);
        try{
            String json = mapper.writeValueAsString(clazz);
            log.info(json);
            
            mapper.writeValue(new File("src/main/resources/clazz.json"), clazz);
            
            SomeClass clazz2 = mapper.readValue(new File("src/main/resources/clazz.json"), SomeClass.class);
        } catch (Exception e) {
            log.error("Object Mapper exception" + e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
